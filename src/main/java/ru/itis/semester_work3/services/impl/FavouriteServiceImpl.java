package ru.itis.semester_work3.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.dto.FavouriteDto;
import ru.itis.semester_work3.entity.BookEntity;
import ru.itis.semester_work3.entity.FavouriteEntity;
import ru.itis.semester_work3.entity.UserEntity;
import ru.itis.semester_work3.repo.BookRepository;
import ru.itis.semester_work3.repo.FavouriteRepository;
import ru.itis.semester_work3.repo.UserRepository;
import ru.itis.semester_work3.services.FavouriteService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {
    private final FavouriteRepository favouriteRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public void addFavourite(FavouriteDto favouriteDto) {
        UserEntity user = userRepository.findUserByUserId(favouriteDto.getUserId()).get();
        BookEntity book = bookRepository.findById(favouriteDto.getBookId()).get();
        FavouriteEntity newFavourite = FavouriteEntity.builder()
                .user(user)
                .book(book)
                .build();
        favouriteRepository.save(newFavourite);

    }

    @Override
    public void deleteFavourite(FavouriteDto favouriteDto) {
        UserEntity user = userRepository.findUserByUserId(favouriteDto.getUserId()).get();
        BookEntity book = bookRepository.findById(favouriteDto.getBookId()).get();
        FavouriteEntity favourite = FavouriteEntity.builder()
                .user(user)
                .book(book)
                .build();
        favouriteRepository.delete(favourite);
    }

    @Override
    public List<FavouriteDto> getUsersFavourites(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        List<FavouriteDto> userFavourites = new ArrayList<>();
        if (user!= null) {
            userFavourites = favouriteRepository
                    .findFavouriteEntitiesByUser(user)
                    .stream()
                    .map(it -> FavouriteDto.builder()
                            .userId(it.getUser().getUserId())
                            .bookId(it.getBook().getBookId())
                            .build()).toList();
        }
        return userFavourites;
    }


}
