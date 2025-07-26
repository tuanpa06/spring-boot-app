package com.tuandev.app.Dto.Request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CreateBankRequest {
    @NotBlank(message = "Username cannot be blank")
    String name;

    @NotBlank(message = "Password cannot be blank")
    String password;

    String code;
    String description;
}
