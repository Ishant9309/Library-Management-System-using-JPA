# Library Management System

A simple Java console-based application to manage books using JPA and Hibernate (6.x) with PostgreSQL.

---

## Features

- Add new books (Title, Author, Quantity)
- View all books
- Search book by ID
- Update book details
- Delete book
- exit..

---

## Technologies Used

- Java (JDK 21+)
- PostgreSQL
- JPA
- Hibernate 6.x
- Maven

---

## Dependencies

```xml
<dependencies>
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.4.4.Final</version>
        </dependency>

        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
        </dependency>

        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.1.0</version>
        </dependency>
    </dependencies>
</project>

```
---
## Output

<img width="825" height="291" alt="Screenshot 2025-07-14 180625" src="https://github.com/user-attachments/assets/5e32a6bb-e628-49ac-a6ae-dfce948dcfc6" />
<img width="1113" height="876" alt="Screenshot 2025-07-14 180650" src="https://github.com/user-attachments/assets/5d6d8eca-f986-4d58-a5e6-3f7d9e2cf646" />

---
## Prerequisites
- Java must be installed (JDK 21 or higher)
- PostgreSQL should be installed and running
- Database and table will be automatically created by Hibernate (hbm2ddl.auto = update)
```
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    quantity INT
);
```
---

## Contact
- Name: Ishant Teli
- Email: ishantteli27@gmail.com
- GitHub: Ishant9309






