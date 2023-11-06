package repository;
import config.HibernateConfig;
import entities.Book;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepository {
    public void save(Book book){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            session.close();
        }
    }
    public void update(Book book){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory();){
            Session session2 = sessionFactory.openSession();

            Transaction transactionUpdate  = session2.beginTransaction();
            session2.merge(book);
            transactionUpdate.commit();
            session2.close();
        }
    }

    public List<Book> findAll(){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            TypedQuery<Book> listOfBooks = session.createQuery("select b from Book b", Book.class);
            List<Book> bookList = listOfBooks.getResultList();
            session.close();
            return bookList;
        }

    }

    public void delete(Book book){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(book);
            transaction.commit();
            session.close();
        }

    }
    public Book findById (Integer id){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            TypedQuery<Book> listOfBooks = session.createQuery("select b from Book b where b.id = ?1", Book.class)
                    .setParameter(1,id);
            Book bookFound = listOfBooks.getSingleResult();
            session.close();
            return bookFound;
        }
    }
}