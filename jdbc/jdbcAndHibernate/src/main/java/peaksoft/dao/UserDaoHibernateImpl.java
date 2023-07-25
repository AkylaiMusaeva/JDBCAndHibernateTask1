package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {


    }

    @Override
    public void dropUsersTable() {
        Session session=Util.getSession().openSession();
        session.beginTransaction();
        session.createNativeQuery("drop table users").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table is successfully dropped! ");

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        User user=new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.merge(user);
        session.getTransaction().commit();
        session.close();
        System.out.println(name+ " student is saved successfully!");
    }

    @Override
    public void removeUserById(long id) {


        Session session=Util.getSession().openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("User with id="+id+" is successfully deleted! ");
    }


    @Override
    public List<User> getAllUsers() {
        Session session=Util.getSession().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("select u from User u",User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session=Util.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table is successfully cleaned! ");
    }
}
