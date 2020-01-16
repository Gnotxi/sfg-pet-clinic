package jccm.spring.spring5webapp.respositories;

import org.springframework.data.repository.CrudRepository;

import jccm.spring.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
