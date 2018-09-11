package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.mrgeneralq.servertickets.enums.TicketTeleportType;
import me.mrgeneralq.servertickets.events.TicketTeleportEvent;
import me.mrgeneralq.servertickets.utils.ColorUtils;

public class OnTicketTeleport implements Listener {
	
	@EventHandler
	public void onTicketTeleport(TicketTeleportEvent e)
	{
		Player helper = Bukkit.getPlayer(e.getTicket().getHelperId());
		Player requester = Bukkit.getPlayer(e.getTicket().getRequesterId());
		TicketTeleportType teleportType = e.getTeleportType();
		
		if(teleportType == TicketTeleportType.StaffToTicket) {
			helper.sendMessage(ColorUtils.toColor("&3You teleported to the location of the ticket!"));
			requester.sendMessage(ColorUtils.toColor("&2" + helper.getName() + "&6 teleported to the location where you created the ticket!"));
		}

	}
}
