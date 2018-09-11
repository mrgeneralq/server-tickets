package me.mrgeneralq.servertickets.commands;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.enums.TicketStatus;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.statics.TicketMessage;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class SosCommand implements CommandExecutor {
	
	private ITicketService ticketService;
	
	public SosCommand(ITicketService ticketService) {
		this.ticketService = ticketService;
	}
	


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
		if(!(sender instanceof Player))
			return true;
		
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("servertickets.sos")) {
			player.sendMessage(ColorUtils.toColor(TicketMessage.noPermissionMessage));
			return false;
		}
		
		if(args.length == 0) {
			player.sendMessage(ColorUtils.toColor("&4Use the following syntax: &3/sos <your message>"));
			return false;
		}
		
		
		if(ticketService.getPlayerTicket(player) != null) {
			player.sendMessage(ColorUtils.toColor("&cYou already created a ticket. Please wait for the first ticket to be resolved"));
			return false;
		}
		
		// creating the ticket
		Random random = new Random();		
		Ticket ticket = new Ticket(random.nextInt(random.nextInt(999)));
		
		while(ticketService.alreadyExists(ticket))
			ticket = new Ticket(random.nextInt(random.nextInt(999)));
				
		ticket.setMessage(Arrays.stream(args).collect(Collectors.joining(" ")));
		ticket.setLocation(player.getLocation());
		ticket.setRequester(player);
		ticket.setPrivate(false);
		ticket.setStatus(TicketStatus.Open);
		
		// creating the ticket
		ticketService.create(ticket);	
		return false;
	}
		

}
