package agh.hafid.com.webapp.bootstrap;

import agh.hafid.com.webapp.model.Author;
import agh.hafid.com.webapp.model.Book;
import agh.hafid.com.webapp.model.Publisher;
import agh.hafid.com.webapp.repositories.AuthorRepository;
import agh.hafid.com.webapp.repositories.BookRepository;
import agh.hafid.com.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public InitData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // create a publisher
        Publisher publisher = new Publisher("hafid id-baha","address","city name","the state","65464");
        publisherRepository.save(publisher);

        Author hafid = new Author("hafid","id-baha");
        Book book = new Book("learn iot","1346545");

        hafid.getBooks().add(book);
        book.getAuthors().add(hafid);
        book.setPublisher(publisher);

        publisher.getBooks().add(book);


        authorRepository.save(hafid);
        bookRepository.save(book);



        System.out.println("started in bootstrap");
        System.out.println("number of books in database "+bookRepository.count());
        System.out.println("number of authors in database "+authorRepository.count());
        System.out.println("publishers count in databse  "+publisherRepository.count());
    }
}
