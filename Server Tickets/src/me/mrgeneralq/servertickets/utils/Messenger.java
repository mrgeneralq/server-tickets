package me.mrgeneralq.servertickets.utils;

import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.model.Ticket;

public class Messenger {
	
	private Messenger() {}
	
	public static void broadcastNewTicketCreated(Ticket ticket) {
		
		
		Bukkit.getPlayer(ticket.getRequesterId()).sendMessage(ColorUtils.toColor("&2Ticket created! &3A staff member will soon help you out!"));
		
		Bukkit.getOnlinePlayers().stream().filter(p -> p.hasPermission("servertickets.staff")).collect(Collectors.toList()).forEach(
				p ->p.sendMessage(ColorUtils.toColor("&5New ticket created with id: &6" + ticket.getTicketId()))
				);
			
		}
	
	
	public static void broadcastTicketInProgress(Ticket ticket) {
		
		
		Player requester = Bukkit.getPlayer(ticket.getRequesterId());
		Player helper = Bukkit.getPlayer(ticket.getHelperId());
		
		requester.sendMessage("You are assisted by " + helper.getName());
		helper.sendMessage("You are helping " + requester.getName());
		helper.sendMessage("Problem: " + ticket.getMessage());
		
		
	}
			
}

