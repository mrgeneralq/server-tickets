package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.mrgeneralq.servertickets.enums.ReprocessCause;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;

public class OnPlayerLeave implements Listener {
	
	private final ITicketService ticketService;
	
	public OnPlayerLeave(ITicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		
		Player player = e.getPlayer();
		
		Ticket ticket = ticketService.getPlayerTicket(player);
		if(ticket == null)
			return;
		
		if(ticket.getHelperId() == player.getUniqueId()) {
			ticketService.reprocessTicket(ticket, ReprocessCause.HelperDisconnected);
		}else {
			ticketService.closeTicket(ticket);
		}

		
		
		
		
	}

}
