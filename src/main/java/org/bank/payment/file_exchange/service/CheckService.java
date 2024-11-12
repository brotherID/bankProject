package org.bank.payment.file_exchange.service;

import org.bank.payment.file_exchange.dtos.CheckDTO;

public interface CheckService {
    CheckDTO addCheck(CheckDTO checkDTO, String idDiscount);
    CheckDTO getCheckByIdCheck(String idCheck);
}
