package booksApi.services;

import booksApi.dao.BookRepository;
import booksApi.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBookById(int id){
        Book book = null;
        try{
            book = this.bookRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b){
        Book result = bookRepository.save(b);
        return result;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);
    }
}
