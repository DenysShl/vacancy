package ua.cv.vacancy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
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
    @NonNull
    private String email;

    @Column(name = "message")
    @NonNull
    private String message;

    @Column(name = "created_on")
    private LocalDateTime created_on;
}