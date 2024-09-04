package com.library.libraryManagement.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }
    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Vous pouvez personnaliser selon vos besoins
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Vous pouvez personnaliser selon vos besoins
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Vous pouvez personnaliser selon vos besoins
    }

    @Override
    public boolean isEnabled() {
        return true; // Vous pouvez personnaliser selon vos besoins
    }
}
