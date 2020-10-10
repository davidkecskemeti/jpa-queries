package com.dk.jpa.queries.runner;

import com.dk.jpa.queries.custom.repository.NoteRepository;
import com.dk.jpa.queries.derived.repository.UserRepository;
import com.dk.jpa.queries.named.entity.Book;
import com.dk.jpa.queries.named.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowCommandLineRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Like pattern
//            String pattern = "%atta%@gmail%";
//            List<User> users = userRepository.findByEmailLike(pattern);

        // pagination
//            Pageable pageable = PageRequest.of(0, 10, Sort.by("name").descending());
//            Page<User> userPage = userRepository.findByActive(true, pageable);

        // notes sorting
//            List<Note> startupNotes = noteRepository.findByTitle("startup", Sort.by("title").ascending());
//            List<Note> techNotes = noteRepository.findByTitle("tech", Sort.by("priority").descending());
//            List<Note> lengthyNotes = noteRepository.findByTitle("tech", JpaSort.unsafe("LENGTH(title)"));

        // notes pagination
//            Pageable pageable = PageRequest.of(0, 10, Sort.by("title").descending());
//            Page<Note> notePage = noteRepository.findAllNotesWithPagination(pageable);

        // create books
        bookRepository.save(new Book("Java 101", "145804", 450));
        bookRepository.save(new Book("Spring Bot", "48524", 289));

        // execute named queries with `EntityManager`
//            Query q = em.createNamedQuery("Book.findByTitleJPQL");
//            q.setParameter(1, "Java 101");
//            // execute query
//            List<Book> books = q.getResultList();
//
        // execute native sql named query
//            Query q = em.createNamedQuery("Book.findByIsbnNative");
//            q.setParameter("isbn", "145804");
//            // execute query
//            Book book = (Book) q.getSingleResult();

        // list all books
        List<Book> books = bookRepository.findAllXML();

        // fetch a single book
//        Book book = bookRepository.findByIsbnNamedFile("145804");

        // multiple parameters
//        List<Book> moreBooks = bookRepository.findByTitleAndPagesGreaterThanJPQL("Spring Bot", 150);

    }
}
