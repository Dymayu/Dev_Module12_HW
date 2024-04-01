package org.example.dao;

import org.example.entity.Planet;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudDaoImpl implements PlanetCrudDao {
    @Override
    public boolean createPlanet(Planet planet) {
        boolean result = false;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.persist(planet);
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
    public boolean updatePlanet(Planet planet) {
        boolean result = false;
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.merge(planet);
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
    public Planet getPlanetById(String planetId) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            return session.get(Planet.class, planetId);
        }
    }

    @Override
    public List<Planet> getAllPlanets() {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            return session.createQuery("FROM Planet", Planet.class).list();
        }
    }

    @Override
    public void deletePlanetById(String planetId) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                Planet planet = session.get(Planet.class, planetId);
                session.remove(planet);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }

        }
    }

    @Override
    public void deletePlanet(Planet planet) {
        try(Session session = HibernateUtils.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try{
                session.remove(planet);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
        }
    }
}
