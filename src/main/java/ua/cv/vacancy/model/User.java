package ua.cv.vacancy.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @version 1.0
 * @autor shd on 24.11.2021
 * @created 24.11.2021 - 23:39
 * @project vacancy
 */

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    @NotEmpty(message = "Login should not be empty")
    @Size(min = 5, message = "Login size should be min 5 characters")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 8, message = "Password size should be min 8 characters")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @Column(name = "status")
    private Status status;
}
