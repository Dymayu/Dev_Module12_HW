package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        planet.setPlanetId(id);
        planet.setName(name);
        return planet;
    }

    private static Ticket prepareTicket(LocalDateTime createdAt, Client clientId, Planet fromPlanetId, Planet toPlanetId){
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(createdAt);
        ticket.setClientId(clientId);
        ticket.setFromPlanetId(fromPlanetId);
        ticket.setToPlanetId(toPlanetId);
        return ticket;
    }

    private static Ticket prepareTicket(Integer id, LocalDateTime createdAt, Client clientId, Planet fromPlanetId, Planet toPlanetId){
        Ticket ticket = prepareTicket(createdAt, clientId, fromPlanetId, toPlanetId);
        ticket.setTicketId(id);
        return ticket;
    }


    public static void main(String[] args) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();

        // Client
        ClientCrudService clientCrudService = new ClientCrudService();

        // Create client
        //clientCrudService.create(prepareClient("test222"));
        // Update client - Christopher Martinez
     //   clientCrudService.update(prepareClient(7, "UpdTest4"));
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
    //    Planet planetById = planetCrudService.getPlanetById("VNS");
    //    System.out.println("Planet By ID = " + planetById);
        // Get all planets
    //    List<Planet> allPlanets = planetCrudService.getAllPlanets();
    //    allPlanets.forEach(planet -> System.out.println("planet = " + planet));
        // Delete planet by ID - MRS
    //    planetCrudService.deletePlanetById("MRS");
        // Delete planet
    //    planetCrudService.deletePlanet(preparePlanet("STN", "Saturn"));

        TicketCrudService ticketCrudService = new TicketCrudService();

        // Create ticket                        LocalDate createdAt,    Client clientId, Planet fromPlanetId, Planet toPlanetId
//        ticketCrudService.create(
//                prepareTicket(LocalDateTime.now(),
//                        prepareClient(3,"Michael Brown"),
//                        preparePlanet("NPT", "Neptune"),
//                        preparePlanet("VNS", "Venus")));

        // Update ticket
//        ticketCrudService.update(
//                prepareTicket(7, LocalDateTime.now(),
//                        prepareClient(3,"Michael Brown"),
//                        preparePlanet("VNS", "Neptune"),
//                        preparePlanet("NPT", "Venus")));
        // Get ticket by ID
//        Ticket ticket = ticketCrudService.getTicketById(10);
//        System.out.println("ticketCrudService = " + ticket);
        // Get all tickets
//        List<Ticket> allTickets = ticketCrudService.getAllTickets();
//        allTickets.forEach(ticket -> System.out.println("ticket = " + ticket));
        // Delete ticket by ID
//            ticketCrudService.deleteTicketById(1);
        // Delete ticket
//        ticketCrudService.deleteTicket(prepareTicket(2, LocalDateTime.parse("2030-05-14T08:44:08"), prepareClient(5, "David Wilson"),preparePlanet("NPT", "Neptune"),preparePlanet("MRS","Mars")));
    }

}
