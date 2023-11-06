package config;

import entities.Author;
import entities.AuthorBook;
import entities.Book;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

        public static Configuration getConfiguration(){
            return new Configuration()
                    .addAnnotatedClass(Author.class)
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(AuthorBook.class)
                    .configure("hibernate.cfg.xml");
        }
    }

