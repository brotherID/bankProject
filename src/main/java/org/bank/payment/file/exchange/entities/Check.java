package org.bank.payment.file.exchange.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Entity(name = "checkBank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Check {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private  String idCheck;
    private  String cmc7;
    private  String amount;
    private boolean signature;
    private boolean provision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private  Discount discount;
}
