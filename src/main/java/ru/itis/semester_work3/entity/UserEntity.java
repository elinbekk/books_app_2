package ru.itis.semester_work3.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.itis.semester_work3.entity.enums.Role;
import ru.itis.semester_work3.entity.enums.State;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String username;
    private String city;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BLOCKED;
    }

    @OneToMany(mappedBy = "books")
    @JoinColumn(name = "userId")
    private List<BookEntity> books;
}
