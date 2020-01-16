package jccm.spring.spring5webapp.respositories;

import org.springframework.data.repository.CrudRepository;

import jccm.spring.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
