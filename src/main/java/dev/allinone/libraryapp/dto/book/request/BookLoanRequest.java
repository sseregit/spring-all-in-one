package dev.allinone.libraryapp.dto.book.request;

public record BookLoanRequest(
        String userName,
        String bookName
) {
}
