package ru.itis.semester_work3.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Builder

public class BookDto {
    private UUID bookId;
    private String title;
    private String author;
    private UUID ownerId;
}
