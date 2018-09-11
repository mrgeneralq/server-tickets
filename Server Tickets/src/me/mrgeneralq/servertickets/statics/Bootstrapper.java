package me.mrgeneralq.servertickets.statics;

import me.mrgeneralq.servertickets.interfaces.IRepository;
import me.mrgeneralq.servertickets.interfaces.ITicketService;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.repositories.TicketRepository;
import me.mrgeneralq.servertickets.services.TicketService;

public class Bootstrapper {
	
	
	IRepository<Ticket> ticketRepository;
	ITicketService ticketService;
	
	
	private static Bootstrapper instance;
	
	private Bootstrapper() {}
	
	public static Bootstrapper getBootstrapper() {
		if(instance == null)
			instance = new Bootstrapper();
		return instance;
	}
	
	
	
	
	public void run() {
		ticketRepository = new TicketRepository(); 
		ticketService = new TicketService(this.ticketRepository);	
	}
	
	
	public IRepository<Ticket> getTicketRepository(){
		return this.ticketRepository;
	}
	
	public ITicketService getTicketService() {
		return this.ticketService;
	}

}
