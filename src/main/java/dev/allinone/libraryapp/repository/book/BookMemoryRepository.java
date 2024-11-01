package dev.allinone.libraryapp.repository.book;

import dev.allinone.libraryapp.service.book.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
class BookMemoryRepository implements BookRepository {

//    private final List<Book> books = new ArrayList<>();

    @Override
    public void saveBook() {
//        books.add(new Book());
        System.out.println("BookMemoryRepository.saveBook");
    }
}
