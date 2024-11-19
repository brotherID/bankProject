package org.bank.payment.file.exchange.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
    private String idDiscount;
    private BigDecimal amountDiscount;
    private Date dateDiscount;
    private String codeBank;
    private Collection<CheckDTO> checks;
}
