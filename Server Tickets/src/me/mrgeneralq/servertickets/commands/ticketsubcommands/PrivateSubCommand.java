package me.mrgeneralq.servertickets.commands.ticketsubcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.interfaces.ISubCommand;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.statics.TicketMessage;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class PrivateSubCommand implements ISubCommand {

	private final ITicketService ticketService;
	public PrivateSubCommand(ITicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	
	@Override
	public void execute(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("servertickets.private")) {
			player.sendMessage(TicketMessage.noPermissionMessage);
			return;
		}
		
		if(args.length != 1) {
			player.sendMessage(ColorUtils.toColor("&5Use: &6/ticket private"));
			return;
		}
		
		Ticket ticket = ticketService.getPlayerTicket(player);
		
		if(ticket == null) {
			player.sendMessage(ColorUtils.toColor("&cYou are not in a ticket right now!"));
			return;
		}
		
		ticketService.togglePrivate(ticket);
		
	}

}
