package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// в данном тесте в первой части меняем зачение поля в таблице, у человека с id=21 ставим зарплату salary = 1100;
// во второй части теста установим зарплату равную 900 всем сотрудникам с именем Alex
public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Owner.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Owner target = session.get(Owner.class, 21);
            target.setSalary(1100);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Owner set salary=900" +
                    "WHERE name='Alex' ").executeUpdate();
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
