package me.mrgeneralq.servertickets.eventlisteners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.mrgeneralq.servertickets.events.TicketCreateEvent;
import me.mrgeneralq.servertickets.utils.Messenger;

public class OnTicketCreate implements Listener {
	
	@EventHandler
	public void onTicketCreate(TicketCreateEvent e) {
		
		Messenger.broadcastNewTicketCreated(e.getTicket());	
		
	}

}
