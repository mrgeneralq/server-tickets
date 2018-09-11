package me.mrgeneralq.servertickets.interfaces;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface ISubCommand {
	
	void execute(CommandSender sender, Command cmd, String CommandLabel, String[] args);

}
