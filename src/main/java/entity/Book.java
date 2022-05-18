package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Amount", nullable = false)
    private Integer amount;

    @Column(name = "Country", nullable = false, length = 20)
    private String country;

    @Column(name = "Year", nullable = false, length = 4)
    private Integer year;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn (name="ID_Author")
    private Author author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Lending> lendings;

    public Book() {
    }

    public Book(String name, Integer amount, String country, Integer year, Author author, List<Lending> lendings) {
        this.name = name;
        this.amount = amount;
        this.country = country;
        this.year = year;
        this.author = author;
        this.lendings = lendings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(List<Lending> lendings) {
        this.lendings = lendings;
    }

    @Override
    public String toString() {
        return "[id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", author=" + author + ']';
    }
}
