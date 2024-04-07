package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Ticket;

import java.util.List;

public interface TicketCrudDao {
    boolean createTicket(Ticket ticket);

    boolean updateTicket(Ticket ticket);

    Ticket getTicketById(Integer ticketId);

    List<Ticket> getAllTickets();

    void deleteTicketById(Integer ticketId);

    void deleteTicket(Ticket ticket);
}
