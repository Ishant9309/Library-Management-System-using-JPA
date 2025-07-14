package com.library.dao;
import com.library.entity.Book;
import com.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class BookDAO {
    public void addBook(Book book) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }
    public List<Book> getAllBooks() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();
        em.close();
        return books;
    }
    public Book findBookById(int id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Book book = em.find(Book.class, id);
        em.close();
        return book;
    }

    public void updateBook(Book book) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteBook(int id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        em.close();
    }
}
