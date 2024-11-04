package dev.allinone.libraryapp.service.book;

import dev.allinone.libraryapp.domain.book.Book;
import dev.allinone.libraryapp.domain.book.BookRepository;
import dev.allinone.libraryapp.domain.user.User;
import dev.allinone.libraryapp.domain.user.UserRepository;
import dev.allinone.libraryapp.domain.user.loanhistory.UserLoanHistory;
import dev.allinone.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import dev.allinone.libraryapp.dto.book.request.BookCreateRequest;
import dev.allinone.libraryapp.dto.book.request.BookLoanRequest;
import dev.allinone.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.name()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        Book book = bookRepository.findByName(request.bookName())
                .orElseThrow(IllegalArgumentException::new);

        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("진작 대출되어 있는 책입니다.");
        }

        User user = userRepository.findByName(request.userName())
                .orElseThrow(IllegalArgumentException::new);

        userLoanHistoryRepository.save(new UserLoanHistory(user, book.getName()));

    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        User user = userRepository.findByName(request.userName())
                .orElseThrow(IllegalArgumentException::new);

        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.bookName())
                .orElseThrow(IllegalArgumentException::new);

        history.doReturn();
    }

}
