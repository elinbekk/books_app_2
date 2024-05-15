package ru.itis.semester_work3.services;

import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.entity.BookEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BooksService {
    void saveBook(BookDto book);
    List<BookDto> getAllBooks();
    Optional<BookEntity> getBookById(UUID id);
    BookDto getBookDtoById(UUID id);
    void deleteBookById(UUID id);
    List<BookDto> getBooksByUserId(UUID userId);
    List<BookDto> getBooksByTitle(String title);
    List<BookDto> getBooksByAuthor(String author);
    List<BookDto> getBookByTitleContaining(String title);
}
