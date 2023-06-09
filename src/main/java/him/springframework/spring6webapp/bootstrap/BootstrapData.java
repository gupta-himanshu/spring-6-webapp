package him.springframework.spring6webapp.bootstrap;

import him.springframework.spring6webapp.domain.Author;
import him.springframework.spring6webapp.domain.Book;
import him.springframework.spring6webapp.domain.Publisher;
import him.springframework.spring6webapp.repositories.AuthorRepository;
import him.springframework.spring6webapp.repositories.BookRepository;
import him.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author him = new Author();
        him.setFirsName("Himanshu");
        him.setLastName("Gupta");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("098765");

        Author himSaved = authorRepository.save(him);
        Book dddSaved = bookRepository.save(ddd);

        Author kin = new Author();
        him.setFirsName("Kanika");
        him.setLastName("Gupta");

        Book rts = new Book();
        ddd.setTitle("Road to Success");
        ddd.setIsbn("123456");

        Author kinSaved = authorRepository.save(kin);
        Book rtsSaved = bookRepository.save(rts);


        Publisher github = new Publisher();
        github.setPublisherName("Github");
        github.setAddress("US");
        github.setCity("Ohio");
        github.setState("Columbus");
        github.setZip("123456");
        Publisher githubSaved = publisherRepository.save(github);

        dddSaved.setPublisher(githubSaved);
        rtsSaved.setPublisher(githubSaved);

        himSaved.getBooks().add(dddSaved);
        kinSaved.getBooks().add(rtsSaved);

        authorRepository.save(himSaved);
        authorRepository.save(kinSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(rtsSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());

        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
