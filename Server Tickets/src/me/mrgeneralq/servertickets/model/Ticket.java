package me.mrgeneralq.servertickets.model;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.enums.TicketStatus;


public class Ticket {

	// unique value for ticket
	private int ticketId;
	
	
	private String message;

	private Location location;
	
	private UUID requesterId;
	private UUID helperId;
	
	private TicketStatus status;
	
	private Boolean isPrivate;
	
	private HashMap<Player, Location> oldLocations = new HashMap<Player, Location>();
	
	// constructor
	public Ticket(int ticketId) {
		this.ticketId = ticketId;
	}
		
	// setters
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setRequester(Player player) {
		this.requesterId = player.getUniqueId();
	}
	
	public void setHelperId(UUID uuid) {
		this.helperId = uuid;
	}
	
	public void setHelper(Player player) {
		this.helperId = player.getUniqueId();
	}
	
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	public void setPrivate(Boolean bool) {
		this.isPrivate = bool;
	}

	// getters
	
	public int getTicketId() {
		return this.ticketId;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public UUID getRequesterId() {
		return this.requesterId;
	}
	
	public UUID getHelperId() {
		return this.helperId;
	}
	
	public TicketStatus getStatus() {
		return this.status;
	}
	
	public Boolean isPrivate() {
		return this.isPrivate;
	}
	
	public HashMap<Player, Location> getOldPlayerLocations(){
		return oldLocations;
		
	}
	
	
}
