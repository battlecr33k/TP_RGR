package entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lending")
public class Lending {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="ID_Reader")
    private Reader reader;

    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="ID_Book")
    private Book book;
    @Temporal(TemporalType.DATE)
    @Column(name = "Data", nullable = false, length = 10)
    private Date data;

    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="ID_Worker")
    private Worker worker;

    public Lending() {
    }

    public Lending(Reader reader, Book book, Date data, Worker worker) {
        this.reader = reader;
        this.book = book;
        this.data = data;
        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "[id=" + id +
                ", reader=" + reader +
                ", book=" + book +
                ", data=" + data +
                ", worker=" + worker + ']';
    }
}
