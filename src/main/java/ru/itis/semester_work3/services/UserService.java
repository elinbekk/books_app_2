package ru.itis.semester_work3.services;

import ru.itis.semester_work3.dto.UserDto;
import ru.itis.semester_work3.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
        void registerUser(UserDto userDto);
        Optional<UserEntity> getUserByUsername(String email);
        List<UserDto> getAllUsers();
        boolean isUserExists(String email);
}
