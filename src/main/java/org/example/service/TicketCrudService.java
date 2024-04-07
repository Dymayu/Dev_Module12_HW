package org.example.service;

import org.example.dao.ClientCrudDaoImpl;
import org.example.dao.TicketCrudDaoImpl;
import org.example.entity.Client;
import org.example.entity.Ticket;

import java.util.List;

public class TicketCrudService {
    TicketCrudDaoImpl ticketCrudDao = new TicketCrudDaoImpl();

    public boolean create(Ticket ticket){
        return ticketCrudDao.createTicket(ticket);
    }

    public boolean update(Ticket ticket){
        return ticketCrudDao.updateTicket(ticket);
    }

    public Ticket getTicketById(Integer ticketId){
        return ticketCrudDao.getTicketById(ticketId);
    }

    public List<Ticket> getAllTickets(){
        return ticketCrudDao.getAllTickets();
    }
    public void deleteTicketById(Integer ticketId){
        ticketCrudDao.deleteTicketById(ticketId);
    }
    public void deleteTicket(Ticket ticket){
        ticketCrudDao.deleteTicket(ticket);
    }
}
