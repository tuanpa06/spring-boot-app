package com.tuandev.app.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    User user;

    @ManyToOne
    @JoinColumn(name = "bankId", referencedColumnName = "id")
    Bank bank;

    String number;
    int balance;
    int isActive = 1;
    LocalDate createdAt;
    LocalDate updatedAt;
}
