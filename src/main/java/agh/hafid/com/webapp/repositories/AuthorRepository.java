package agh.hafid.com.webapp.repositories;

import agh.hafid.com.webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
