package ru.itis.semester_work3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semester_work3.entity.BookEntity;
import ru.itis.semester_work3.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
    Optional<BookEntity> findById(UUID id);
    List<BookEntity> findBookEntitiesByOwner(UserEntity owner);
    List<BookEntity> findBookEntitiesByTitle(String title);
    List<BookEntity> findBookEntitiesByAuthor(String author);
    List<BookEntity> findBookEntitiesByTitleContainsIgnoreCase(String title);
}
