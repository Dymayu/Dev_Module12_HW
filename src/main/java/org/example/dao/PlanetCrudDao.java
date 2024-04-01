package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Planet;

import java.util.List;

public interface PlanetCrudDao {

    boolean createPlanet(Planet planet);

    boolean updatePlanet(Planet planet);

    Planet getPlanetById(String planetId);

    List<Planet> getAllPlanets();

    void deletePlanetById(String planetId);

    void deletePlanet(Planet planet);
}
