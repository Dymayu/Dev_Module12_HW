package org.example.service;

import org.example.dao.ClientCrudDaoImpl;
import org.example.dao.PlanetCrudDaoImpl;
import org.example.entity.Client;
import org.example.entity.Planet;

import java.util.List;

public class PlanetCrudService {
    PlanetCrudDaoImpl planetCrudDao = new PlanetCrudDaoImpl();

    public boolean create(Planet planet){
        return planetCrudDao.createPlanet(planet);
    }

    public boolean update(Planet planet){
        return planetCrudDao.updatePlanet(planet);
    }

    public Planet getPlanetById(String planetId){
        return planetCrudDao.getPlanetById(planetId);
    }

    public List<Planet> getAllPlanets(){
        return planetCrudDao.getAllPlanets();
    }
    public void deletePlanetById(String planetId){
        planetCrudDao.deletePlanetById(planetId);
    }
    public void deletePlanet(Planet planet){
        planetCrudDao.deletePlanet(planet);
    }
}
