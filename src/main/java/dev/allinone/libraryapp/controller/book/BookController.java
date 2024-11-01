package dev.allinone.libraryapp.controller.book;

import dev.allinone.libraryapp.dto.book.BookCreateRequest;
import dev.allinone.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
record BookController(
        BookService bookService
) {

    @PostMapping("/book")
    void saveBook(@RequestBody BookCreateRequest request) {
        bookService.saveBook(request);
    }
}
