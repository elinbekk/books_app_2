package ru.itis.semester_work3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semester_work3.entity.BookEntity;
import ru.itis.semester_work3.entity.FavouriteEntity;
import ru.itis.semester_work3.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface FavouriteRepository extends JpaRepository<FavouriteEntity, UUID> {
    List<FavouriteEntity> findFavouriteEntitiesByUser(UserEntity user);
}
