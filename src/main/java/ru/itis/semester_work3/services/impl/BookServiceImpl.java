package ru.itis.semester_work3.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.entity.BookEntity;
import ru.itis.semester_work3.entity.UserEntity;
import ru.itis.semester_work3.repo.BookRepository;
import ru.itis.semester_work3.repo.UserRepository;
import ru.itis.semester_work3.services.BooksService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BooksService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    //todo: add book photos saving
    @Override
    public void saveBook(BookDto bookDto) {
        UserEntity owner = userRepository.findById(bookDto.getOwnerId()).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден"));

        BookEntity newBook = BookEntity.builder()
                .author(bookDto.getAuthor())
                .title(bookDto.getTitle())
                .bookPhotoUrl(bookDto.getPhotoUrl())
                .owner(owner)
                .build();
        bookRepository.save(newBook);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookDto> allBooks =  bookRepository.findAll().stream().map(
                it -> BookDto.builder()
                        .bookId(it.getBookId())
                        .title(it.getTitle())
                        .author(it.getAuthor())
                        .photoUrl(it.getBookPhotoUrl())
                        .ownerId(it.getOwner().getUserId())
                        .build()).toList();
        return allBooks;
    }

    @Override
    public BookDto getBookById(UUID id) {
        return null;
    }

    @Override
    public void deleteBookById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<BookDto> getBooksByUserId(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        List<BookDto> userBooks = new ArrayList<>();
        if (userEntity != null) {
            userBooks = bookRepository
                    .findBookEntitiesByOwner(userEntity)
                    .stream()
                    .map(it -> BookDto.builder()
                            .bookId(it.getBookId())
                            .title(it.getTitle())
                            .author(it.getAuthor())
                            .photoUrl(it.getBookPhotoUrl())
                            .build()).toList();
        }
        return userBooks;
    }

    @Override
    public List<BookDto> getBooksByTitle(String title) {
        List<BookDto> books =  bookRepository.findBookEntitiesByTitle(title).stream().map(
                it -> BookDto.builder()
                        .bookId(it.getBookId())
                        .title(it.getTitle())
                        .author(it.getAuthor())
                        .photoUrl(it.getBookPhotoUrl())
                        .ownerId(it.getOwner().getUserId())
                        .build()).toList();
        return books;
    }

    @Override
    public List<BookDto> getBooksByAuthor(String author) {
        List<BookDto> books =  bookRepository.findBookEntitiesByAuthor(author).stream().map(
                it -> BookDto.builder()
                        .bookId(it.getBookId())
                        .title(it.getTitle())
                        .author(it.getAuthor())
                        .photoUrl(it.getBookPhotoUrl())
                        .ownerId(it.getOwner().getUserId())
                        .build()).toList();
        return books;
    }

    @Override
    public List<BookDto> getBookByTitleContaining(String title) {
        List<BookDto> books =  bookRepository.findBookEntitiesByTitleContainsIgnoreCase(title).stream().map(
                it -> BookDto.builder()
                        .bookId(it.getBookId())
                        .title(it.getTitle())
                        .author(it.getAuthor())
                        .photoUrl(it.getBookPhotoUrl())
                        .ownerId(it.getOwner().getUserId())
                        .build()).toList();
        return books;
    }


}
