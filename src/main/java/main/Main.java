package main;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();


        //  Вывести всех авторов и их книги.
        List<Author> authors = session.createQuery("FROM Author").list();

        for (Author author : authors) {
            System.out.println("Author: " + author + "\nBooks:");
            if (!author.getBooks().isEmpty()) author.getBooks().forEach(System.out::println);
            else System.out.println("No books available.");

        }

        //  Вывести кол-во книг в биоблиотеке.
        List<Integer> cnt = session.createQuery("SELECT SUM(amount) FROM Book").list();
        System.out.println("\nКол-во книг в библиотеке: " + cnt.get(0));


        //  Вывести информацию о последней выдаче книги.
        List<Lending> lending = session.createQuery("FROM Lending ORDER BY Data DESC").list();
        System.out.println(lending.get(0));


        session.flush();
        transaction.commit();
        session.close();
        sf.close();

    }
}
