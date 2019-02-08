package ks.bookstore.blerim.domain;

import org.springframework.data.repository.CrudRepository;

import ks.bookstore.blerim.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
