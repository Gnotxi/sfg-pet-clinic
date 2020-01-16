package jccm.spring.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import jccm.spring.spring5webapp.model.Author;
import jccm.spring.spring5webapp.model.Book;
import jccm.spring.spring5webapp.model.Publisher;
import jccm.spring.spring5webapp.respositories.AuthorRepository;
import jccm.spring.spring5webapp.respositories.BookRepository;
import jccm.spring.spring5webapp.respositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository=publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		
		Publisher publisher = new Publisher();
		publisher.setName("Yo lo he publicado");
		
		
		publisherRepository.save(publisher);
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Doman Diven Design", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rober = new Author("Rober", "García");
		Book ddd2 = new Book("Segundo libro", "2", publisher);
		rober.getBooks().add(ddd2);

		authorRepository.save(rober);
		bookRepository.save(ddd2);
	}
}
