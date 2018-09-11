package me.mrgeneralq.servertickets.services;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.enums.ReprocessCause;
import me.mrgeneralq.servertickets.enums.TicketStatus;
import me.mrgeneralq.servertickets.events.TicketCloseEvent;
import me.mrgeneralq.servertickets.events.TicketCreateEvent;
import me.mrgeneralq.servertickets.events.TicketReprocessEvent;
import me.mrgeneralq.servertickets.events.TicketTogglePrivateEvent;
import me.mrgeneralq.servertickets.interfaces.IRepository;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;

public class TicketService implements ITicketService{

		
	private IRepository<Ticket> ticketRepository;
		

	public TicketService(IRepository<Ticket> ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	
	@Override
	public Ticket getTicket(int id) {
		
		return ticketRepository.get(id);
	}


	@Override
	public void create(Ticket ticket) {		
		ticketRepository.create(ticket);		
		Bukkit.getServer().getPluginManager().callEvent(new TicketCreateEvent(ticket));
	}


	@Override
	public boolean alreadyExists(Ticket ticket) {
		return ticketRepository.exists(ticket);
	}


	@Override
	public void update(Ticket ticket) {
		ticketRepository.update(ticket);	
	}


	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.getAll();
	}


	@Override
	public void removeTicket(Ticket ticket) {
		ticketRepository.delete(ticket);
		
	}


	@Override
	public void closeTicket(Ticket ticket) {
		Bukkit.getPluginManager().callEvent(new TicketCloseEvent(ticket));
		removeTicket(ticket);
	}


	@Override
	public Ticket getPlayerTicket(Player player) {
		return getAllTickets().stream().filter(t -> t.getHelperId() == player.getUniqueId() || t.getRequesterId() == player.getUniqueId()).findFirst().orElse(null);
	}


	@Override
	public void togglePrivate(Ticket ticket) {

		Ticket newTicket = ticket;
		
		if(newTicket.isPrivate()) {
			newTicket.setPrivate(false);
		}else {
			newTicket.setPrivate(true);			
		}
			
		
		ticketRepository.update(newTicket);
		Bukkit.getPluginManager().callEvent(new TicketTogglePrivateEvent(newTicket));
		
	}


	@Override
	public void reprocessTicket(Ticket ticket, ReprocessCause cause) {
		Ticket retrievedTicket = ticket;
		retrievedTicket.setStatus(TicketStatus.Open);
		retrievedTicket.setHelperId(null);
		ticketRepository.update(retrievedTicket);
		
		Bukkit.getPluginManager().callEvent(new TicketReprocessEvent(retrievedTicket, cause));
		
	}


	@Override
	public List<Ticket> getAllOpenTickets() {
		// TODO Auto-generated method stub
		return getAllTickets().stream().filter(t -> t.getStatus() == TicketStatus.Open)
        .collect(Collectors.toList());
	}


	@Override
	public void returnAllPlayersFromTicket(Ticket ticket) {
		for(Player player: ticket.getOldPlayerLocations().keySet()) {			
			if(player.isOnline()) {
				player.teleport(ticket.getOldPlayerLocations().get(player));
			}

		}
		
	}

}
