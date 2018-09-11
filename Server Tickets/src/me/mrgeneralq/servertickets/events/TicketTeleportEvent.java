package me.mrgeneralq.servertickets.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.mrgeneralq.servertickets.enums.TicketTeleportType;
import me.mrgeneralq.servertickets.model.Ticket;

public class TicketTeleportEvent extends Event{
	
	
	private Ticket ticket;
	private TicketTeleportType teleportType;
	
	private static final HandlerList handlers = new HandlerList();
	
	public TicketTeleportEvent(Ticket ticket, TicketTeleportType teleportType) {
		this.ticket = ticket;
		this.teleportType = teleportType;
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
	
	public TicketTeleportType getTeleportType() {
		return this.teleportType;
	}

}
