package ru.itis.semester_work3.dto;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String middleName;
   // private Date birthday;
    private String city;
//    @Email
    private String username;
    private String password;
}