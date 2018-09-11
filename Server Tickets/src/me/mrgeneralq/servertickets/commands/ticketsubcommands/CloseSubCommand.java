package me.mrgeneralq.servertickets.commands.ticketsubcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.interfaces.ISubCommand;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.statics.TicketMessage;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class CloseSubCommand implements ISubCommand {

	private final ITicketService ticketservice;
	public CloseSubCommand(ITicketService ticketService) {
		this.ticketservice = ticketService;
	}
	
	@Override
	public void execute(CommandSender sender, Command cmd, String CommandLabel, String[] args) {


		Player player = (Player) sender;
		
		if(!player.hasPermission("servertickets.close")) {
			player.sendMessage(TicketMessage.noPermissionMessage);
			return;
		}
		
		if(args.length != 1)
		{
			player.sendMessage(ColorUtils.toColor("&5Use: &6/ticket close"));
			return;
		}
		
		
		Ticket ticket = ticketservice.getPlayerTicket(player);
		
		if(ticket == null)
		{
			player.sendMessage("&4You are not in a ticket right now!");
			return;
		}
		
		
		ticketservice.closeTicket(ticket);
	}

}
