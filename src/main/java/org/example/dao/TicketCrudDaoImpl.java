package org.example.dao;

import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudDaoImpl implements TicketCrudDao{

    @Override
    public boolean createTicket(Ticket ticket) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                ticket.setTicketId(null);
                session.persist(ticket);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.getMessage();
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        boolean result = false;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.merge(ticket);
                transaction.commit();
                result = true;
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public Ticket getTicketById(Integer ticketId) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            return session.get(Ticket.class, ticketId);
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            return session.createQuery("FROM Ticket", Ticket.class).list();
        }
    }

    @Override
    public void deleteTicketById(Integer ticketId) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                Ticket ticket = session.get(Ticket.class, ticketId);
                session.remove(ticket);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }

        }
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.remove(ticket);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
        }
    }
}
