package org.bank.payment.file_exchange.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Builder
@Entity(name = "discountBank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String idDiscount;
    private BigDecimal amountDiscount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date dateDiscount;
    private String  codeBank;

    @OneToMany(mappedBy = "discount",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Check> checks;
}
