package me.mrgeneralq.servertickets.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.commands.ticketsubcommands.ClaimSubCommand;
import me.mrgeneralq.servertickets.commands.ticketsubcommands.CloseSubCommand;
import me.mrgeneralq.servertickets.commands.ticketsubcommands.ListSubCommand;
import me.mrgeneralq.servertickets.commands.ticketsubcommands.PrivateSubCommand;
import me.mrgeneralq.servertickets.commands.ticketsubcommands.TPSubCommand;
import me.mrgeneralq.servertickets.interfaces.ISubCommand;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class TicketCommand implements CommandExecutor {

	private HashMap<String, ISubCommand> subCommands = new HashMap<String,ISubCommand>();
	private ITicketService ticketService;
	
	public TicketCommand(ITicketService ticketService) {
		this.ticketService = ticketService;
		
		subCommands.put("claim", new ClaimSubCommand(this.ticketService));
		subCommands.put("tp", new TPSubCommand(this.ticketService));
		subCommands.put("close", new CloseSubCommand(this.ticketService));
		subCommands.put("private", new PrivateSubCommand(this.ticketService));
		subCommands.put("list", new ListSubCommand(this.ticketService));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		
		if(!(sender instanceof Player))
		return true;
		
		Player player = (Player) sender;
		
		if(args.length == 0)
		{
			player.sendMessage(ColorUtils.toColor("help menu method comes here"));
			return true;
		}
				
		subCommands.getOrDefault(args[0].toLowerCase(),new ErrorCommand()).execute(sender,cmd,CommandLabel,args);
			
		return false;
	}

}
