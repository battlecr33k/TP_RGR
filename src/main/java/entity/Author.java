package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Surname", nullable = false, length = 20)
    private String surname;

    @Column(name = "Name", nullable = false, length = 15)
    private String name;

    @Column(name = "Patronymic", nullable = true, length = 30)
    private String patronymic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public Author() {
    }

    public Author(String surname, String name, String patronymic, List<Book> books) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        if (patronymic != null) {
            return "[id=" + id +
                    ", surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    ", patronymic='" + patronymic + '\'' + ']';
        } else {
            return "[id=" + id +
                    ", surname='" + surname + '\'' +
                    ", name='" + name + '\'' + ']';
        }
    }
}
