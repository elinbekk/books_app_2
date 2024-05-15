package ru.itis.semester_work3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "favourite")
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID favouriteId;

    @ManyToOne
    //@JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    //@JoinColumn(name = "book_id")
    private BookEntity book;
}
