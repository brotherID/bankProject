package org.bank.payment.file.exchange.service;

import lombok.AllArgsConstructor;
import org.bank.payment.file.exchange.dtos.CheckDTO;
import org.bank.payment.file.exchange.entities.Check;
import org.bank.payment.file.exchange.entities.Discount;
import org.bank.payment.file.exchange.mapper.CheckMapper;
import org.bank.payment.file.exchange.repository.CheckRepository;
import org.bank.payment.file.exchange.repository.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CheckServiceImpl implements CheckService{

    private final CheckMapper checkMapper;

    private final CheckRepository checkRepository;

    private final DiscountRepository discountRepository;

    @Override
    public CheckDTO addCheck(CheckDTO checkDTO, String idDiscount) {
        Discount discount = discountRepository.findById(idDiscount)
                .orElseThrow(() -> new RuntimeException("Discount not found with ID: " + idDiscount));
        Check check = checkMapper.toCheck(checkDTO);
        check.setDiscount(discount);
        check =   checkRepository.save(check);
        return checkMapper.toCheckDTO(check);
    }

    @Override
    public CheckDTO getCheckByIdCheck(String idCheck) {
        Check check =  checkRepository.findById(idCheck).orElseThrow(()-> new RuntimeException("Check not found with ID: " + idCheck));
        return checkMapper.toCheckDTO(check);
    }

    @Override
    public Optional<CheckDTO> getCheckById(String checkId) {
       return  checkRepository.findById(checkId)
               .map(checkMapper::toCheckDTO);
    }
}