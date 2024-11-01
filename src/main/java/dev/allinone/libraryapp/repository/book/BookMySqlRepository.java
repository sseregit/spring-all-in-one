package dev.allinone.libraryapp.repository.book;

import dev.allinone.libraryapp.service.book.BookRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
class BookMySqlRepository implements BookRepository {

    @Override
    public void saveBook() {
        System.out.println("BookMySqlRepository.saveBook");
    }
}
