package hu.helixlab.spring.bootstrap;

import hu.helixlab.spring.domain.Author;
import hu.helixlab.spring.domain.Book;
import hu.helixlab.spring.domain.Category;
import hu.helixlab.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init(){
        Book book = new Book();
        book.setIsbn(String.valueOf(UUID.randomUUID()));
        book.setName("Java course I.");

        Category category = new Category();
        category.setName("Horror");
        category.setShortDescription("Very scary books for brave men");

        book.addCategory(category);

        Author author = new Author();
        author.setName("Béla");
        author.setAge(32);
        author.setEmail("bela@gmail.com");

        book.addAuthor(author);



        bookRepository.save(book);
    }
}
