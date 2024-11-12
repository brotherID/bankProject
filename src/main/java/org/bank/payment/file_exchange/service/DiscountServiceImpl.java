package org.bank.payment.file_exchange.service;

import lombok.AllArgsConstructor;
import org.bank.payment.file_exchange.dtos.CheckDTO;
import org.bank.payment.file_exchange.dtos.DiscountDTO;
import org.bank.payment.file_exchange.entities.Check;
import org.bank.payment.file_exchange.entities.Discount;
import org.bank.payment.file_exchange.repository.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DiscountServiceImpl implements  DiscountService{

    private final  DiscountRepository discountRepository;


    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {

        Discount discount = new Discount();
        discount.setAmountDiscount(discountDTO.getAmountDiscount());
        discount.setDateDiscount(new Date());
        discount.setCodeBank(discountDTO.getCodeBank());
        discount = discountRepository.save(discount);
        DiscountDTO discountDTO1 = new DiscountDTO();
        discountDTO1.setIdDiscount(discount.getIdDiscount());
        discountDTO1.setAmountDiscount(discount.getAmountDiscount());
        discountDTO1.setCodeBank(discount.getCodeBank());
        discountDTO1.setDateDiscount(discount.getDateDiscount());
        return discountDTO1;
    }

    @Override
    public DiscountDTO getDiscountByIdDiscount(String idDiscount) {
        Discount discount =  discountRepository.findById(idDiscount).orElseThrow(() -> new RuntimeException("Discount not found with ID: " + idDiscount));
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setIdDiscount(discount.getIdDiscount());
        discountDTO.setAmountDiscount(discount.getAmountDiscount());
        discountDTO.setDateDiscount(discount.getDateDiscount());
        discountDTO.setCodeBank(discount.getCodeBank());

        Collection<CheckDTO> checkDTOs = discount.getChecks().stream()
                .map(this::convertToCheckDTO)
                .collect(Collectors.toList());

        discountDTO.setChecks(checkDTOs);
        return discountDTO;
    }



    private CheckDTO convertToCheckDTO(Check check) {
        CheckDTO checkDTO = new CheckDTO();
        checkDTO.setIdCheck(check.getIdCheck());
        checkDTO.setCmc7(check.getCmc7());
        checkDTO.setProvision(check.isProvision());
        checkDTO.setAmount(check.getAmount());
        checkDTO.setSignature(check.isSignature());
        checkDTO.setDiscountId(check.getDiscount().getIdDiscount());
        return checkDTO;
    }
}
