package com.library.libraryManagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans;

    public User(Long id) {
        this.id = id;
    }

    public enum Role {
        ADMIN, LIBRARIAN, USER
    }


}
