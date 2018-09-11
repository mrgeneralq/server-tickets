package me.mrgeneralq.servertickets.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.mrgeneralq.servertickets.model.Ticket;

public class TicketCloseEvent extends Event{
	
	private Ticket ticket;
	private static final HandlerList handlers = new HandlerList();
	
	public TicketCloseEvent(Ticket ticket) {
		this.ticket = ticket;
	}
	
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
	
	public Ticket getTicket() {
		return this.ticket;
	}

}
