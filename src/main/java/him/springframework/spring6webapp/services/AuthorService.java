package him.springframework.spring6webapp.services;

import him.springframework.spring6webapp.domain.Author;

public interface AuthorService {


    Iterable<Author> findAll();
}
