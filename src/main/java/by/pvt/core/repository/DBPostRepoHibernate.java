package by.pvt.core.repository;

import by.pvt.core.config.HibernateJavaConfig;
import by.pvt.core.domain.Posts;
import by.pvt.core.repository.interfaces.InterfaceDbPostRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class DBPostRepoHibernate implements InterfaceDbPostRepo {
    private SessionFactory sessionFactory;

    public DBPostRepoHibernate() {
        sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addPost(Posts post) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(post);
        session.getTransaction().commit();
        session.evict(post);
        session.close();
    }

    @Override
    public List<Posts> getListPost() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select * from guest.post");
        List<Posts> allpost = query.getResultList();
        return allpost;
    }

    @Override
    public Posts findById(Long postID) {
        Session session = sessionFactory.openSession();
        Posts post = session.get(Posts.class, postID);
        return post;
    }

    @Override
    public void delPost(long id) {
        Session session = sessionFactory.openSession();
        Posts posts = session.get(Posts.class, id);
        session.getTransaction().begin();
        session.remove(posts);
        session.close();
    }


}
