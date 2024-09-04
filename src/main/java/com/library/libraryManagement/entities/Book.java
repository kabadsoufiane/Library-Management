package com.library.libraryManagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "books")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    private String imageUrl;
    private String author;
    private Integer publicationYear;
    private String summary;
    private boolean isAvailable = true; // Par défaut, le livre est disponible

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

    public Book(Long id) {
        this.id = id;
    }
}
