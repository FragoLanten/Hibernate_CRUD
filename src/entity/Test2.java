package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
// в данном тесте запращиваем все объекты(строчки) из существующе базы данных
public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Owner> newOwners = session.createQuery("from Owner")
                    .getResultList();

            for (Owner owners:newOwners) {
                System.out.println(owners);
            }
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
