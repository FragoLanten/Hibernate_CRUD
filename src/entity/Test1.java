package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// в данном тесте добавляем 5 пользователей в базу данных
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Owner owner = new Owner("Vadim", 32, 500);
            session.beginTransaction();
            session.save(owner);
            session.getTransaction().commit();

            Session session2 = factory.getCurrentSession();
            Owner owner2 = new Owner("Alex", 25, 700);
            session2.beginTransaction();
            session2.save(owner2);
            session2.getTransaction().commit();

            Session session3 = factory.getCurrentSession();
            Owner owner3 = new Owner("Alex", 23, 800);
            session3.beginTransaction();
            session3.save(owner3);
            session3.getTransaction().commit();

            Session session4 = factory.getCurrentSession();
            Owner owner4 = new Owner("Elena", 30, 400);
            session4.beginTransaction();
            session4.save(owner4);
            session4.getTransaction().commit();

            Session session5 = factory.getCurrentSession();
            Owner owner5 = new Owner("Roman", 27, 550);
            session5.beginTransaction();
            session5.save(owner5);
            session5.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
