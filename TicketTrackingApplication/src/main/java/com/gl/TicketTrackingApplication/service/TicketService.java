package com.gl.TicketTrackingApplication.service;

import java.util.List;

import com.gl.TicketTrackingApplication.entity.Ticket;

public interface TicketService {
	
	List<Ticket> getAllTickets();
	
	Ticket addTicket(Ticket ticket);
	
	Ticket getTicketById(Long id);
	
	Ticket updateTicket(Ticket ticket);
	
	void deleteTicketByid(Long id);
	
	//List<Product> findAllProducts(String keyword);
	//List<Ticket> findAllTickets(String keyword);
	
	//get employees by keyword
	public List<Ticket> findByKeyword(String keyword);
}
