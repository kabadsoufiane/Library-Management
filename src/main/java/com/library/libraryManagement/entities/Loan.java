package com.library.libraryManagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "loans")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private LocalDate dateOfLoan;

    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate returnDate;
    private Double penalty;
}
