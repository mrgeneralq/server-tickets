package me.mrgeneralq.servertickets.commands.ticketsubcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mrgeneralq.servertickets.enums.TicketStatus;
import me.mrgeneralq.servertickets.events.TicketClaimEvent;
import me.mrgeneralq.servertickets.interfaces.ISubCommand;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.statics.TicketMessage;
import me.mrgeneralq.servertickets.utils.ColorUtils;


public class ClaimSubCommand implements ISubCommand {

	
	private ITicketService ticketService;
	
	public ClaimSubCommand(ITicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@Override
	public void execute(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		
		if(!player.hasPermission("ticket.claim")) 
		{
			player.sendMessage(ColorUtils.toColor(TicketMessage.noPermissionMessage));
			return;
		}
		
		
		if(ticketService.getPlayerTicket(player) != null) {
			player.sendMessage(ColorUtils.toColor("&cYou are already in another ticket!"));
			return;
		}
		
		if(!(args.length == 2)) {
			player.sendMessage(ColorUtils.toColor("&5type &6/ticket claim <ticketID>"));
			return;
		}
		
		int ticketId;
		try {
			ticketId = Integer.parseInt(args[1]);
		}catch (Exception e) {
			player.sendMessage(ColorUtils.toColor("&4The ticket ID is a numeric value!"));
			return;
		}		
		
		
		Ticket ticket = new Ticket(ticketId);
		
		if(!ticketService.alreadyExists(ticket)) {
			player.sendMessage(ColorUtils.toColor("&4Ticket not found!"));
			return;
		}
		
		
		if(ticketService.getTicket(ticket.getTicketId()).getStatus() == TicketStatus.InProgress) {
			player.sendMessage(ColorUtils.toColor("&4Someone else is already taking care of this ticket!"));
			return;
		}
		
		Ticket requesterTicket = ticketService.getTicket(ticket.getTicketId());
		requesterTicket.setHelperId(player.getUniqueId());
		requesterTicket.setStatus(TicketStatus.InProgress);
		
		ticketService.update(requesterTicket);
		Bukkit.getServer().getPluginManager().callEvent(new TicketClaimEvent(requesterTicket));
	}
}
