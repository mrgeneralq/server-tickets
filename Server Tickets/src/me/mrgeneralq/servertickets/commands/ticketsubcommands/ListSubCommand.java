package me.mrgeneralq.servertickets.commands.ticketsubcommands;


import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.mrgeneralq.servertickets.interfaces.ISubCommand;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.statics.TicketMessage;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class ListSubCommand implements ISubCommand {
	
	private final ITicketService ticketService;
	
    public ListSubCommand(ITicketService ticketService) {
		this.ticketService = ticketService;
	}
	

	@Override
	public void execute(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("servertickets.list")) {
			player.sendMessage(ColorUtils.toColor(TicketMessage.noPermissionMessage));
			return;
		}
		
		if(args.length != 1) {
			player.sendMessage(ColorUtils.toColor("&5Use: &6/ticket list"));
			return;
		}
				
		if(ticketService.getAllOpenTickets().size() == 0) {
			player.sendMessage(ColorUtils.toColor("&bThere are no open tickets!"));
			return;
		}
		
		
		player.sendMessage(ColorUtils.toColor("&5open tickets: &6" + ticketService.getAllOpenTickets().stream().map(t -> String.valueOf(t.getTicketId())).collect(Collectors.joining(", "))));

	}

}
