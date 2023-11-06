package repository;

import config.HibernateConfig;
import entities.Author;

import entities.Book;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorRepository {
    public void save(Author author){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(author);
            transaction.commit();
            session.close();
        }
    }
    public void update(Author author){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory();){
            Session session2 = sessionFactory.openSession();
            Transaction transactionUpdate  = session2.beginTransaction();
            session2.merge(author);
            transactionUpdate.commit();
            session2.close();
        }
    }
    public List<Author> findAll(){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            TypedQuery<Author> listOfAuthor = session.createQuery("select b from Author b", Author.class);
            List<Author> authorList = listOfAuthor.getResultList();
            session.close();
            return authorList;
        }

    }
    public void delete(Author author){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(author);
            transaction.commit();
            session.close();
        }

    }
    public Author findAuthorById (Integer id){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            TypedQuery<Author> listOfAuthor = session.createQuery("select a from Author a where a.id = ?1", Author.class)
                    .setParameter(1,id);
            Author authorFound = listOfAuthor.getSingleResult();
            session.close();
            return authorFound;
        }
    }

}
