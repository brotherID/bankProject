package org.bank.payment.file_exchange.service;

import lombok.AllArgsConstructor;
import org.bank.payment.file_exchange.dtos.CheckDTO;
import org.bank.payment.file_exchange.entities.Check;
import org.bank.payment.file_exchange.entities.Discount;
import org.bank.payment.file_exchange.repository.CheckRepository;
import org.bank.payment.file_exchange.repository.DiscountRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckServiceImpl implements CheckService{

    private final CheckRepository checkRepository;

    private final DiscountRepository discountRepository;

    @Override
    public CheckDTO addCheck(CheckDTO checkDTO, String idDiscount) {
        Discount discount = discountRepository.findById(idDiscount)
                .orElseThrow(() -> new RuntimeException("Discount not found with ID: " + idDiscount));
        Check check =  new Check();
        check.setAmount(checkDTO.getAmount());
        check.setCmc7(checkDTO.getCmc7());
        check.setSignature(checkDTO.isSignature());
        check.setProvision(checkDTO.isProvision());
        check.setDiscount(discount);
        check =   checkRepository.save(check);
        CheckDTO checkDTO1= new CheckDTO();
        checkDTO1.setIdCheck(check.getIdCheck());
        checkDTO1.setAmount(check.getAmount());
        checkDTO1.setCmc7(check.getCmc7());
        checkDTO1.setSignature(check.isSignature());
        checkDTO1.setProvision(check.isProvision());
        checkDTO1.setDiscountId(check.getDiscount().getIdDiscount());
        return checkDTO1;
    }

    @Override
    public CheckDTO getCheckByIdCheck(String idCheck) {
        Check check =  checkRepository.findById(idCheck).orElseThrow(()-> new RuntimeException("Check not found with ID: " + idCheck));
        CheckDTO checkDTO = new CheckDTO();
        checkDTO.setIdCheck(check.getIdCheck());
        checkDTO.setAmount(check.getAmount());
        checkDTO.setSignature(check.isSignature());
        checkDTO.setProvision(check.isProvision());
        checkDTO.setDiscountId(check.getDiscount().getIdDiscount());
        checkDTO.setCmc7(check.getCmc7());
        return checkDTO;
    }
}
