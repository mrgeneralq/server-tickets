package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.mrgeneralq.servertickets.events.TicketCloseEvent;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class OnTicketClose implements Listener {

	@EventHandler
	public void onTicketClose(TicketCloseEvent e) {
		Ticket ticket = e.getTicket();
		
		
		
		if(ticket.getHelperId() != null && Bukkit.getPlayer(ticket.getHelperId()).isOnline()) {
			Player helper = Bukkit.getPlayer(ticket.getHelperId());
			helper.sendMessage(ColorUtils.toColor("&cTicket has been closed!"));
		}
		
		if(ticket.getRequesterId() != null && Bukkit.getPlayer(ticket.getRequesterId()).isOnline()) {
			Player requester = Bukkit.getPlayer(ticket.getRequesterId());
			requester.sendMessage(ColorUtils.toColor("&cTicket has been closed!"));
		}		
		
	}
	
}
