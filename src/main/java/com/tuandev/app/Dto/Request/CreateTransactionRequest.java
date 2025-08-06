package com.tuandev.app.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequest {
    String senderNumber;
    String receiverNumber;
    String senderBank;
    String receiverBank;
    int amount;
    String note;
}
