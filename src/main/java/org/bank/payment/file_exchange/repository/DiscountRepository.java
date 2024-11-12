package org.bank.payment.file_exchange.repository;

import org.bank.payment.file_exchange.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,String> {
}
