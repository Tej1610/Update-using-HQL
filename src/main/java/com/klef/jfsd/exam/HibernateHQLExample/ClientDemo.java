package com.klef.jfsd.exam.HibernateHQLExample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        // HQL Update Operation
        String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE departmentId = ?3";
        int updatedRows = session.createQuery(hql)
                .setParameter(1, "Updated Name")
                .setParameter(2, "Updated Location")
                .setParameter(3, 1)
                .executeUpdate();

        System.out.println("Number of rows updated: " + updatedRows);

        tx.commit();
        session.close();
        factory.close();
    }
}
