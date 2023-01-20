package com.gl.TicketTrackingApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.TicketTrackingApplication.entity.Ticket;

	@Repository
	public interface TicketRepository extends JpaRepository<Ticket, Long>{
		
		///////////////////search///////////////////
		
//		List<Product> search(String keyword);
//		@Query("SELECT ticket FROM Ticket ticket WHERE CONCAT(ticket.ticketTitle, ' ', ticket.ticketDescription)LIKE %?1%")
//		public List<Ticket> search(String keyword);
//		//public Ticket findByName(String name);
//		public Ticket findByTitle(String name);
//		///////////////////search///////////////////
		
		@Query(value="SELECT * FROM Ticket ticket WHERE CONCAT(ticket.ticketTitle,' ', ticket.ticketDescription) LIKE %:keyword%", nativeQuery =true)
		List<Ticket> findByKeyword(@Param("keyword") String keyword);
		
		
	}

//SELECT * FROM Ticket ticket WHERE CONCAT ticket.ticketTitle like %:keyword% or ticket.ticketDescription like %:keyword%"