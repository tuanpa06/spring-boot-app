package com.tuandev.app.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class BankResponse {
    int id;
    String username;
    String password;
    String email;
    int gender;
    String phoneNumber;
    LocalDate bod;
    String address;
    int identity;
}
