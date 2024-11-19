package org.bank.payment.file.exchange.repository;

import org.bank.payment.file.exchange.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,String> {
}
