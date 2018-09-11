package me.mrgeneralq.servertickets.interfaces;

import java.util.List;

import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.enums.ReprocessCause;
import me.mrgeneralq.servertickets.model.Ticket;

public interface ITicketService {
	
	Ticket getTicket(int id);
	void create(Ticket ticket);
	boolean alreadyExists(Ticket ticket);
	void update(Ticket ticket);
	List<Ticket> getAllTickets();
	void removeTicket(Ticket ticket);
	void closeTicket(Ticket ticket);
	Ticket getPlayerTicket(Player player);
	void togglePrivate(Ticket ticket);
	void reprocessTicket(Ticket ticket, ReprocessCause cause);
	List<Ticket> getAllOpenTickets();
	void returnAllPlayersFromTicket(Ticket ticket);
	

}
