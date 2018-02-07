package hu.helixlab.spring.service;

import hu.helixlab.spring.domain.Book;
import hu.helixlab.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findById(int id){


        return bookRepository.findOne(id);
    }

    public Book save(Book book){

        return bookRepository.save(book);
    }

    public void deleteById(int id){

        bookRepository.delete(id);
    }

    public Book updateById(int id, Book newBook){

        Book oldBook = bookRepository.findOne(id);
        oldBook.setName(newBook.getName());
        oldBook.setIsbn(newBook.getIsbn());

        return bookRepository.save(oldBook);

    }


}
