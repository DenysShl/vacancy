package ua.cv.vacancy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty!")
    @Email
    private String email;

    @Column(name = "tel")
    @NotEmpty(message = "Phone number should not be empty")
    private String phoneNumber;

    @Column(name = "message")
    @NotEmpty(message = "Message should not be empty")
    @Size(min = 5, message = "should be min 5 characters")
    private String message;

    @Column(name = "created_on")
    private LocalDateTime created_on;
}