package me.mrgeneralq.servertickets.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.mrgeneralq.servertickets.enums.ReprocessCause;
import me.mrgeneralq.servertickets.model.Ticket;

public class TicketReprocessEvent extends Event{
	
	private Ticket ticket;
	private ReprocessCause cause;
	
	private static final HandlerList handlers = new HandlerList();
	
	public  TicketReprocessEvent(Ticket ticket, ReprocessCause cause) {
		this.ticket = ticket;
		this.cause = cause;
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
	
	public ReprocessCause getCause() {
		return this.cause;
	}
	

}
