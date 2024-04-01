package org.example.service;

import org.example.dao.ClientCrudDaoImpl;
import org.example.entity.Client;

import java.util.List;

public class ClientCrudService {
    ClientCrudDaoImpl clientCrudDao = new ClientCrudDaoImpl();

    public boolean create(Client client){
        return clientCrudDao.createClient(client);
    }

    public boolean update(Client client){
        return clientCrudDao.updateClient(client);
    }

    public Client getClientById(Integer clientId){
        return clientCrudDao.getClientById(clientId);
    }

    public List<Client> getAllClients(){
        return clientCrudDao.getAllClients();
    }
    public void deleteClientById(Integer clientId){
        clientCrudDao.deleteClientById(clientId);
    }
    public void deleteClient(Client client){
        clientCrudDao.deleteClient(client);
    }

}
