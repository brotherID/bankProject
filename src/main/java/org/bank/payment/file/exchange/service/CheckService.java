package org.bank.payment.file.exchange.service;

import org.bank.payment.file.exchange.dtos.CheckDTO;

import java.util.Optional;

public interface CheckService {
    CheckDTO addCheck(CheckDTO checkDTO, String idDiscount);


    CheckDTO getCheckByIdCheck(String idCheck);

    Optional<CheckDTO> getCheckById(String checkId);
}
