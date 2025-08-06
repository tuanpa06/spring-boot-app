package com.tuandev.app.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.sql.Timestamp;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Min(5001)
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String senderNumber;
    String receiverNumber;
    String senderBank;
    String receiverBank;

    @Min(value = 5001, message = "Amount must be greater than 5000")
    int amount;

    Timestamp time;
    @PrePersist
    protected void onCreate() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.time = now;
    }

    String note;
}
