package me.mrgeneralq.servertickets.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.interfaces.ISubCommand;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class ErrorCommand implements ISubCommand {

	@Override
	public void execute(CommandSender sender, Command cmd, String CommandLabel, String[] args) {


		Player player = (Player) sender;
		player.sendMessage(ColorUtils.toColor("&4Subcommand not found!"));
		

	}

}
