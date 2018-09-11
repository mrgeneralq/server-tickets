package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.mrgeneralq.servertickets.enums.TicketStatus;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.utils.ColorUtils;


public class OnChat implements Listener {
	
	private final ITicketService ticketService;
	
	
	public OnChat(ITicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
		Player player = e.getPlayer();
		
		Ticket retrievedTicket = ticketService.getPlayerTicket(player);
		
		if(retrievedTicket == null || retrievedTicket.getStatus() == TicketStatus.Open)
			return;
				
		if(!retrievedTicket.isPrivate())
			return;
		
		
		e.setCancelled(true);
		
		Player helper = Bukkit.getPlayer(retrievedTicket.getHelperId());
		Player requester = Bukkit.getPlayer(retrievedTicket.getRequesterId());
		
		
		if(helper.equals(player)) {
			player.sendMessage(ColorUtils.toColor("[&3You&f] &f" + player.getName() +": &e" + e.getMessage()));
			requester.sendMessage(ColorUtils.toColor("[&4Staff&f] " + helper.getName() + ": &b" + e.getMessage()));
		}
		
		if(requester.equals(player)) {
			player.sendMessage(ColorUtils.toColor("[&3You&f] &f" + player.getName() +": &e" + e.getMessage()));
			helper.sendMessage(ColorUtils.toColor("[&4Requester&f] " + player.getName() + ": &b" + e.getMessage()));
		}
		
		
	}

}
