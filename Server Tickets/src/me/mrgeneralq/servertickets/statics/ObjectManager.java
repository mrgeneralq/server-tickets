package me.mrgeneralq.servertickets.statics;

import java.util.ArrayList;
import java.util.List;

import me.mrgeneralq.servertickets.model.Ticket;

public class ObjectManager {
	
	
	private static ObjectManager manager;
	
	public List<Ticket> ticketList = new ArrayList<Ticket>();
	
	
	
	private ObjectManager(){}
	
	
	public static ObjectManager getObjectManager() {
		if(manager == null)
			manager = new ObjectManager();
		return manager;
		
		
	}
	
	
	
}
