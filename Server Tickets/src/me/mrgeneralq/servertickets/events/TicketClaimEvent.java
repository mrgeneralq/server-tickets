package me.mrgeneralq.servertickets.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.mrgeneralq.servertickets.model.Ticket;

public class TicketClaimEvent extends Event{

	private final Ticket ticket;
	private final static HandlerList handlers = new HandlerList();
	
	public TicketClaimEvent(Ticket ticket) {
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
