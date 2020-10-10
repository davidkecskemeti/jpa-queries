package com.dk.jpa.queries.named.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Book.findAllJPQL",
                query = "SELECT b FROM Book b ORDER BY b.title DESC"),
        @NamedQuery(name = "Book.findByTitleJPQL",
                query = "SELECT b FROM Book b WHERE b.title = ?1"),
        @NamedQuery(name = "Book.findByTitleAndPagesGreaterThanJPQL",
                query = "SELECT b FROM Book b WHERE b.title = :title AND b.pages > :pages")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Book.findAllNative",
                query = "SELECT * FROM book b ORDER BY b.title DESC",
                resultClass = Book.class),
        @NamedNativeQuery(name = "Book.findByIsbnNative",
                query = "SELECT * FROM book b WHERE b.isbn = :isbn",
                resultClass = Book.class)
})
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(unique = true)
    private String isbn;
    private int pages;

    public Book(String title, String isbn, int pages) {
        this.title = title;
        this.isbn = isbn;
        this.pages = pages;
    }
}