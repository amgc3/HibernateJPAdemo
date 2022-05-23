package data;

import data.entities.User;
import org.hibernate.Session;

import java.util.Date;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        //user.setUserId(Long.valueOf(2));
        user.setFirstName("Anna");
        user.setLastName("Piva");
        user.setBirthDate(new Date());
        user.setEmailAddress("ap386@yahoo.com");
        user.setLastUpdatedBy("manna");
        user.setLastUpdatedDate(new Date());
        user.setCreatedBy("manna");
        user.setCreatedDate(new Date());

        session.save(user);

        session.getTransaction().commit();

        session.close();

    }
}
