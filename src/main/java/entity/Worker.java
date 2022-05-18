package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "worker")
public class Worker {
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

    @Column(name = "PhoneNumber", nullable = false, length = 12)
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Lending> lendings;

    public Worker() {
    }

    public Worker(String surname, String name, String patronymic, String phoneNumber, List<Lending> lendings) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.lendings = lendings;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' + ']';
    }
}
