package agh.hafid.com.webapp.repositories;

import agh.hafid.com.webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
