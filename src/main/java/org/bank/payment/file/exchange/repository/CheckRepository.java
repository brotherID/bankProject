package org.bank.payment.file.exchange.repository;

import org.bank.payment.file.exchange.entities.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check,String> {
}
