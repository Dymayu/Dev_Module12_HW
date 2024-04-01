package org.example.dao;

import org.example.entity.Client;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudDaoImpl implements ClientCrudDao {

    @Override
    public boolean createClient(Client client) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                client.setId(null);
                session.persist(client);
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
    public boolean updateClient(Client client) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            try {
                session.merge(client);
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
    public Client getClientById(Integer clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            return session.get(Client.class,clientId);
        }
    }

    @Override
    public List<Client> getAllClients() {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            return session.createQuery("from Client", Client.class).list();
        }
    }

    @Override
    public void deleteClientById(Integer clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try{
                Client client = session.get(Client.class, clientId);
                session.remove(client);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
            session.get(Client.class, clientId);
        }

    }

    @Override
    public void deleteClient(Client client) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try{
                session.remove(client);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
        }
    }
}
