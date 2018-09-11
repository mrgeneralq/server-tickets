package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.mrgeneralq.servertickets.events.TicketTogglePrivateEvent;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class OnTicketTogglePrivate implements Listener {

	@EventHandler
	public void onTicketTogglePrivate(TicketTogglePrivateEvent e) {
		
		Ticket ticket = e.getTicket();
		
		Player requester = Bukkit.getPlayer(ticket.getRequesterId());
		Player helper = Bukkit.getPlayer(ticket.getHelperId());
		
		
		if(ticket.isPrivate()) {
			requester.sendMessage(ColorUtils.toColor("&aThis conversation is now private!"));
			helper.sendMessage(ColorUtils.toColor("&aThis conversation is now private!"));
		}else {
			requester.sendMessage(ColorUtils.toColor("&cThis conversation is no longer private!"));
			helper.sendMessage(ColorUtils.toColor("&cThis conversation is no longer private!"));
		}
		

		
	}
}
