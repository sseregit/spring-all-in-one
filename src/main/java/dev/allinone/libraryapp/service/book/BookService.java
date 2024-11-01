package dev.allinone.libraryapp.service.book;

import dev.allinone.libraryapp.domain.book.Book;
import dev.allinone.libraryapp.domain.book.BookRepository;
import dev.allinone.libraryapp.dto.book.BookCreateRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.name()));
    }
}
