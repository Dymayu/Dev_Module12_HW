package org.example.dao;

import org.example.entity.Client;
import java.util.List;

public interface ClientCrudDao {
    boolean createClient(Client client);

    boolean updateClient(Client client);

    Client getClientById(Integer clientId);

    List<Client> getAllClients();

    void deleteClientById(Integer clientId);

    void deleteClient(Client client);


}
