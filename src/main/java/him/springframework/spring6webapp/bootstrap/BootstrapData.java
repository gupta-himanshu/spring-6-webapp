package him.springframework.spring6webapp.bootstrap;

import him.springframework.spring6webapp.domain.Author;
import him.springframework.spring6webapp.domain.Book;
import him.springframework.spring6webapp.repositories.AuthorRepository;
import him.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        himSaved.getBooks().add(dddSaved);
        kinSaved.getBooks().add(rtsSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
