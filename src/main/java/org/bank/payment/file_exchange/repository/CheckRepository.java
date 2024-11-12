package org.bank.payment.file_exchange.repository;

import org.bank.payment.file_exchange.entities.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check,String> {
}
