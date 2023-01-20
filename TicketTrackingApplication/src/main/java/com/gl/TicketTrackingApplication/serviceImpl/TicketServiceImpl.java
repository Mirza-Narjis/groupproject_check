package com.gl.TicketTrackingApplication.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.TicketTrackingApplication.entity.Ticket;
import com.gl.TicketTrackingApplication.repository.TicketRepository;
import com.gl.TicketTrackingApplication.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	//autowired with repository
	@Autowired
	private TicketRepository ticketrepository;
	
	//get from this repository
	public TicketServiceImpl(TicketRepository ticketrepository) {
		this.ticketrepository = ticketrepository;
	}
	
	//get all exisitng tickets
	@Override
	public List<Ticket> getAllTickets() {
		return ticketrepository.findAll();
	}
	
	//add a new ticket
	@Override
	public Ticket addTicket(Ticket ticket) {
		return ticketrepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketrepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		
		Optional<Ticket> result = ticketrepository.findById(ticket.getId());
		Ticket existing = result.get();
		existing.setTicketTitle(ticket.getTicketTitle());
		existing.setTicketDescription(ticket.getTicketDescription());
		existing.setTicketCreationDate(ticket.getTicketCreationDate());
		existing.setContent(ticket.getContent());
		
		return ticketrepository.save(existing); 
		
	}

	@Override
	public void deleteTicketByid(Long id) {
		ticketrepository.deleteById(id);
	}
	
	
	//get employees by keyword
	public List<Ticket> findByKeyword(String keyword) {
		return ticketrepository.findByKeyword(keyword);
	}

//	@Override
//	public List<Ticket> findAllTickets(String keyword) {
//		if(keyword !=null ) {
//			return ticketrepository.search(keyword);
//		}
//		
//		return (List<Ticket>) ticketrepository.findAll();//default JPA method
//	}
	
}
