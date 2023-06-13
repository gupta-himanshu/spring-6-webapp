package him.springframework.spring6webapp.services;

import him.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
