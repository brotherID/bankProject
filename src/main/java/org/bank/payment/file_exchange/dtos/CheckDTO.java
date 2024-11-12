package org.bank.payment.file_exchange.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckDTO {
    private String idCheck;
    private String cmc7;
    private String amount;
    private boolean signature;
    private boolean provision;
    private String discountId;  // Lié à DiscountDTO
}
