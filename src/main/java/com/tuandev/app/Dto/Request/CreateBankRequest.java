package com.tuandev.app.Dto.Request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CreateBankRequest {
    @NotBlank(message = "Bank name cannot be blank")
    String name;
    String code;
    String description;
}
