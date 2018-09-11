package me.mrgeneralq.servertickets.commands.ticketsubcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.enums.TicketTeleportType;
import me.mrgeneralq.servertickets.events.TicketTeleportEvent;
import me.mrgeneralq.servertickets.interfaces.ISubCommand;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.statics.TicketMessage;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class TPSubCommand implements ISubCommand {
	
	private final ITicketService ticketService;
	
	public TPSubCommand(ITicketService ticketService) {
		this.ticketService = ticketService;
	}

	@Override
	public void execute(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("servertickets.teleport"))
		{
			player.sendMessage(TicketMessage.noPermissionMessage);
			return;
		}
		
		if(args.length != 1) {
			player.sendMessage(ColorUtils.toColor("&5use: &6/ticket teleport"));
			return;
		}
		
		
		Ticket ticket = ticketService.getPlayerTicket(player);
		
		if(ticket == null) {
			
			player.sendMessage(ColorUtils.toColor("&4You are not in a ticket right now!"));
			return;
		}
		
		player.teleport(ticket.getLocation());
		Bukkit.getPluginManager().callEvent(new TicketTeleportEvent(ticket,TicketTeleportType.BringPlayer));

	}

}
