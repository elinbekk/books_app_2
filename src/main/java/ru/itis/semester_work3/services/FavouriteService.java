package ru.itis.semester_work3.services;

import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.dto.FavouriteDto;
import ru.itis.semester_work3.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface FavouriteService {
    void addFavourite(FavouriteDto favouriteDto);
    void deleteFavourite(FavouriteDto favouriteDto);
    List<FavouriteDto> getUsersFavourites(UUID userId);
}
