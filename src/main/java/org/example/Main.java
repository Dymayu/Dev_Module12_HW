package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    private static Client prepareClient(String name){
        Client client = new Client();
        client.setName(name);
        return client;
    }

    private static Client prepareClient(int id, String name) {
        Client client = prepareClient(name);
        client.setId(id);
        return client;
    }

    private static Planet preparePlanet(String id, String name){
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);
        return planet;
    }


    public static void main(String[] args) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();

        // Client
        ClientCrudService clientCrudService = new ClientCrudService();

        // Create client
    //    clientCrudService.create(prepareClient("test2"));
        // Update client - Christopher Martinez
    //    clientCrudService.update(prepareClient(7, "UpdTest4"));
        // Get client by ID - Alex Johnson
    //    Client clientById = clientCrudService.getClientById(1);
    //    System.out.println("Client By ID = " + clientById);
        // Get all clients
    //    List<Client> allClients = clientCrudService.getAllClients();
    //    allClients.forEach(client -> System.out.println("client = " + client));
        // Delete client by ID - Emily Smith
    //     clientCrudService.deleteClientById(3);
        // Delete client
    //    clientCrudService.deleteClient(prepareClient(5,"David Wilson"));

        // Planet
        PlanetCrudService planetCrudService = new PlanetCrudService();

        // Create planet
    //    planetCrudService.create(preparePlanet("TST", "Test"));
        // Update planet - NPT
    //    planetCrudService.update(preparePlanet("NPT", "UpdTest"));
        // Get planet by ID - VNS
        Planet planetById = planetCrudService.getPlanetById("VNS");
        System.out.println("Planet By ID = " + planetById);
        // Get all planets
    //    List<Planet> allPlanets = planetCrudService.getAllPlanets();
    //    allPlanets.forEach(planet -> System.out.println("planet = " + planet));
        // Delete planet by ID - MRS
    //    planetCrudService.deletePlanetById("MRS");
        // Delete planet
    //    planetCrudService.deletePlanet(preparePlanet("STN", "Saturn"));

    }

}
