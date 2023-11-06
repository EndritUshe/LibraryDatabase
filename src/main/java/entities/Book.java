package entities;
import jakarta.persistence.*;
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;

    @Column(name = "n_pages")
    private Integer numOfPages;
    @Column(name = "price")
    private Integer price;
    @Column(name = "copies_sold")
    private Integer copiesSold;

    @Column(name = "year")
    private Integer year;

    public Book() {
    }

    public Book(String title, Integer numOfPages, Integer price, Integer copiesSold, Integer year) {
        this.title = title;
        this.numOfPages = numOfPages;
        this.price = price;
        this.copiesSold = copiesSold;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                ", copiesSold=" + copiesSold +
                ", year=" + year +
                '}';
    }
}
