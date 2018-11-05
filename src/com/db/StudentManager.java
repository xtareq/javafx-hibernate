package com.db;

import com.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class StudentManager {

    public SessionFactory sessionFactory;

    public StudentManager() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void create(Student std) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(std);
        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();
    }

    protected void fetch(long $id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Student std = session.get(Student.class, $id);
        System.out.println("Name: " + std.getName());
        System.out.println("Roll: " + std.getRoll());
    }

    public List<Student> fetchAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student").list();
        session.close();

        return students;
    }



    protected void update(long id)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student std = (Student) session.get(Student.class,id);
        std.setName("Hossain Khan");
        session.update(std);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public static void delete(long id)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student std = (Student) session.get(Student.class,id);
        session.delete(std);
        session.getTransaction().commit();
        session.close();

    }
    public static void main(final String[] args) throws Exception {
        StudentManager mn = new StudentManager();
        //mn.create
        //mn.fetch(2);
        //mn.fetchAll();
        //mn.update(2);
        //mn.delete(2);

        System.out.println("Hibernate Curd");
    }
}