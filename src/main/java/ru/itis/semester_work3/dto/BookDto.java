package ru.itis.semester_work3.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private UUID bookId;
    private String title;
    private String author;
    private UUID ownerId;
    private String photoUrl;
}
