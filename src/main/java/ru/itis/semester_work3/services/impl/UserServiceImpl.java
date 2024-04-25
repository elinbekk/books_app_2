package ru.itis.semester_work3.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.semester_work3.dto.UserDto;
import ru.itis.semester_work3.entity.UserEntity;
import ru.itis.semester_work3.entity.enums.Role;
import ru.itis.semester_work3.entity.enums.State;
import ru.itis.semester_work3.repo.UserRepository;
import ru.itis.semester_work3.services.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDto userDto){

        UserEntity newUser = UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .middleName(userDto.getMiddleName())
                .username(userDto.getUsername())
                //.birthDate(userDto.getBirthday())
                .city(userDto.getCity())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .roles(Collections.singleton(Role.USER))
                .state(State.ACTIVE)
                .build();
        userRepository.save(newUser);
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String email) {
        return userRepository.findByUsername(email);
    }

    public boolean isUserExists(String email) {
        return userRepository.existsByUsername(email);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(it -> UserDto.builder()
                        .firstName(it.getFirstName())
                        .lastName(it.getLastName())
                        .username(it.getUsername())
                        .build())
                .toList();
    }
}
