package com.library;
import com.library.dao.BookDAO;
import com.library.entity.Book;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n---Library Menu---");
            System.out.println("1. add Book");
            System.out.println("2. view All Books");
            System.out.println("3. search Book by ID");
            System.out.println("4. update Book");
            System.out.println("5. delete Book");
            System.out.println("6. exit");
            System.out.print("enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine(); 
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    Book book = new Book(title, author, quantity);
                    dao.addBook(book);
                    System.out.println("Book added successfully");
                    break;

                case 2:
                    List<Book> books = dao.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        books.forEach(b -> System.out.println(b.getId() + ". " + b.getTitle() + " by " + b.getAuthor() + " [Qty: " + b.getQuantity() + "]"));
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    Book found = dao.findBookById(id);
                    if (found != null) {
                        System.out.println("Title: " + found.getTitle());
                        System.out.println("Author: " + found.getAuthor());
                        System.out.println("Quantity: " + found.getQuantity());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = sc.nextInt();
                    Book toUpdate = dao.findBookById(updateId);
                    if (toUpdate != null) {
                        sc.nextLine(); 
                        System.out.print("New title: ");
                        toUpdate.setTitle(sc.nextLine());
                        System.out.print("New author: ");
                        toUpdate.setAuthor(sc.nextLine());
                        System.out.print("New quantity: ");
                        toUpdate.setQuantity(sc.nextInt());
                        dao.updateBook(toUpdate);
                        System.out.println("Book updated.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteBook(deleteId);
                    System.out.println("Book deleted if existed.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(6);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
