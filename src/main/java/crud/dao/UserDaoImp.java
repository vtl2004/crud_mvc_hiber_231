package crud.dao;

import crud.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findAllUsers() {
        Session session = sessionFactory.openSession();
       Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User order by id", User.class).list();
        //TypedQuery<User> query=session.createQuery("from User order by id", User.class);
       transaction.commit();
        session.close();
       //return query.getResultList();
        return users;

    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User findUser(long id) {
        User user = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        user = session.get(User.class, id);
        transaction.commit();
        session.close();

        return  user;
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();

    }


}
