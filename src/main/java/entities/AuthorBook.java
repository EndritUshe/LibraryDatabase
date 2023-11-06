package entities;
import jakarta.persistence.*;
@Entity
@Table(name = "author_book")
public class AuthorBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public AuthorBook(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "id=" + id +
                ", author=" + author +
                ", book=" + book +
                '}';
    }
}
