package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.mrgeneralq.servertickets.enums.ReprocessCause;
import me.mrgeneralq.servertickets.events.TicketReprocessEvent;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class OnTicketReprocess implements Listener {
	
	@EventHandler
	public void onTicketReprocess(TicketReprocessEvent e) {
		
		ReprocessCause cause = e.getCause();
		Ticket ticket = e.getTicket();
		
		@SuppressWarnings("unused")
		Player helper = Bukkit.getPlayer(ticket.getHelperId());
		Player requester = Bukkit.getPlayer(ticket.getRequesterId());
		
		
		if(cause == ReprocessCause.HelperDisconnected) {
			requester.sendMessage(ColorUtils.toColor("&cThe helper left but your ticket has been restored into the queue."));
		}
		
		if(cause == ReprocessCause.Command) {
			// placeholder
		}
		
		
	}

}
