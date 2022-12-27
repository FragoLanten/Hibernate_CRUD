package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// в данном тесте удалим объект из базы,
//в первой части один объект,по фиксированному ID
//во второй части удалим 2 объекта по условию
public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Owner owner = session.get(Owner.class, 24);
            session.delete(owner);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE Owner Where salary>1000").executeUpdate();
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
