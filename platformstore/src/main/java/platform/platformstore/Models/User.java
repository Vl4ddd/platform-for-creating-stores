package platform.platformstore.Models;


import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
