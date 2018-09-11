package me.mrgeneralq.servertickets.repositories;


import java.util.List;

import me.mrgeneralq.servertickets.interfaces.IRepository;
import me.mrgeneralq.servertickets.model.Ticket;
import me.mrgeneralq.servertickets.statics.ObjectManager;

public class TicketRepository implements IRepository<Ticket>{

	@Override
	public void create(Ticket ticket) {
		// TODO Auto-generated method stub
		
		
		ObjectManager.getObjectManager().ticketList.add(ticket);
	}

	@Override
	public void delete(Ticket ticket) {
		ObjectManager.getObjectManager().ticketList.removeIf(t -> t.getTicketId() == ticket.getTicketId());
		
	}

	@Override
	public void update(Ticket ticket) {
		ObjectManager.getObjectManager().ticketList.removeIf(t -> t.getTicketId() == ticket.getTicketId());
		ObjectManager.getObjectManager().ticketList.add(ticket);
	}

	@Override
	public Ticket get(int id) {
		return ObjectManager.getObjectManager().ticketList.stream().filter(t -> t.getTicketId() == id).findFirst().get();
	}

	@Override
	public boolean exists(Ticket ticket) {
		return ObjectManager.getObjectManager().ticketList.stream().filter(t -> t.getTicketId() == ticket.getTicketId()).count() > 0;
	}

	@Override
	public List<Ticket> getAll() {
		return ObjectManager.getObjectManager().ticketList;
	}


}
