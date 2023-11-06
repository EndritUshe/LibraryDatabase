package repository;
import config.HibernateConfig;
import entities.AuthorBook;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;
public class AuthorBookRepository {
    public void save(AuthorBook authorBook){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(authorBook);
            transaction.commit();
            session.close();
        }
    }
    public void update(AuthorBook authorBook){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(authorBook);
            transaction.commit();
            session.close();
        }
    }

    public AuthorBook findById(Integer id){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session  = sessionFactory.openSession();
            TypedQuery<AuthorBook> authorBookTypedQuery = session.createQuery("Select ab from AuthorBook ab where ab.id = ?1",AuthorBook.class)
                    .setParameter(1,id);
            return authorBookTypedQuery.getSingleResult();
        }
    }
    public List<AuthorBook> findByBookId(Integer bookId){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session  = sessionFactory.openSession();
            TypedQuery<AuthorBook> findBookIdQuery = session.createQuery
                            ("Select ab from AuthorBook ab join ab.book b where b.id = ?1", AuthorBook.class)
                    .setParameter(1,bookId);
            return findBookIdQuery.getResultList();

        }

    }

    public List<AuthorBook> findAll(){
        try(SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()){
            Session session  = sessionFactory.openSession();
            TypedQuery<AuthorBook> findBookIdQuery =session.createQuery
                    ("select ab from AuthorBook ab", AuthorBook.class);
            List<AuthorBook> authorBookList = findBookIdQuery.getResultList();
            session.close();
            return authorBookList;
        }
    }

    public void delete(AuthorBook authorBook) {
        try (SessionFactory sessionFactory = HibernateConfig.getConfiguration().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(authorBook);
            transaction.commit();
            session.close();
        }
    }

}
