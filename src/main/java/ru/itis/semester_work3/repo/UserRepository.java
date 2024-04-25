package ru.itis.semester_work3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semester_work3.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String email);

    boolean existsByUsername(String username);
}
