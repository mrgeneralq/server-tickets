package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.mrgeneralq.servertickets.events.TicketClaimEvent;
import me.mrgeneralq.servertickets.utils.Messenger;

public class OnTicketClaim implements Listener {
	
	@EventHandler
	public void onTicketClaim(TicketClaimEvent e) {
		
		Messenger.broadcastTicketInProgress(e.getTicket());
		
		
	}

}
