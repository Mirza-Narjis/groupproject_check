package com.gl.TicketTrackingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gl.TicketTrackingApplication.entity.Ticket;
import com.gl.TicketTrackingApplication.service.TicketService;

@Controller
public class TicketController {
	
	@Autowired
	TicketService service;
	
	//display all employees
	
	
	@GetMapping("/")
	public String getAllTickets(Model model, String keyword) {
		List<Ticket> tickets = service.getAllTickets();
		if(keyword != null) {
			model.addAttribute("tickets", service.findByKeyword(keyword));
		}
		else
		{
			model.addAttribute("tickets", tickets);	
		}
		
		
		
		return "main-page";
	}
	
	/*
	@GetMapping("/")
	public String getAllTickets(Model model, @Param("keyword") String keyword) {
		List<Ticket> tickets = service.getAllTickets();
		model.addAttribute("tickets", tickets);
		model.addAttribute("keyword", keyword);
		return "main-page";
	}*/
	
	//Create a new employee
	@GetMapping("/newTicket")
	public String createNewTicket(Model model) {	
		model.addAttribute("ticket", new Ticket());
		return "new-ticket";
	}
	
	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	public String addTicket(@ModelAttribute("ticket") Ticket ticket) {
		service.addTicket(ticket);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String ticketUpdatePage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("ticket", service.getTicketById(id));
		return "update-page";
	}
	
	@RequestMapping("/updateTicket")
	public String updateTicket (Ticket ticket) {
	service.updateTicket(ticket);
	return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Long id) {
		this.service.deleteTicketByid(id);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}")
	public String ticketViewPage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("ticket", service.getTicketById(id));
		return "view-page";
	}
	
}
