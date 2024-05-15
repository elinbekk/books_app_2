package ru.itis.semester_work3.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteDto {
    private UUID favouriteId;
    private UUID userId;
    private UUID bookId;
}
