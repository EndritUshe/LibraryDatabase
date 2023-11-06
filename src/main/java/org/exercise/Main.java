package org.exercise;

import entities.Author;
import entities.AuthorBook;
import entities.Book;
import repository.AuthorBookRepository;
import repository.AuthorRepository;
import repository.BookRepository;

public class Main {
    public static void main(String[] args) {

        //Testing the connection and the methods for each Entity

        /*
        BookRepository bookRepository = new BookRepository();
        AuthorBookRepository authorBookRepository = new AuthorBookRepository();
       AuthorRepository authorRepository = new AuthorRepository();
        authorRepository.save(new Author("Example Test"));
        bookRepository.save(new Book("Test1",500,200,300,50));
       AuthorBook authorBook = new AuthorBook(authorRepository.findAuthorById(25), bookRepository.findById(33));
      System.out.println(authorBookRepository.findAll());
        * */
    }
}