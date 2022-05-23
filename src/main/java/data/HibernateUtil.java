package data;

import data.entities.User;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
// singleton pattern
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            // configuration.addAnnotatedClass(User.class);
            // using the xml configuration this is the approach to follow
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());

        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building the factory :(");
        }
    }

    // to provide access to our singleton
    public static SessionFactory getSessionFactory() {
        return sessionFactory;    }

}
