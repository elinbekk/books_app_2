package ru.itis.semester_work3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookId;
    private String title;
    private String author;
    private  String bookPhotoUrl;
    @ManyToOne
    private UserEntity owner;
}
