package org.example.utils;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.properties.PropertyReader;

import java.sql.SQLException;

public class HibernateUtils {

    private SessionFactory sessionFactory;
    private static final HibernateUtils INSTANCE;

    static {
        try {
            INSTANCE = new HibernateUtils();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public HibernateUtils() throws SQLException {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
        flywayMigration(PropertyReader.getConnectionUrlForDB(),
                PropertyReader.getUserForDB(),
                PropertyReader.getPasswordForDB());
    }

    public static HibernateUtils getInstance(){
        return INSTANCE;
    }
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void closeSessionFactory() {
        this.sessionFactory.close();
    }
    public void flywayMigration(String connectionURL, String user, String password){

        Flyway flyway = Flyway.configure().dataSource(connectionURL,user,password).load();
        flyway.migrate();
    }
}
