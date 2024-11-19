package org.bank.payment.file.exchange.service;

import lombok.AllArgsConstructor;
import org.bank.payment.file.exchange.dtos.DiscountDTO;
import org.bank.payment.file.exchange.entities.Discount;
import org.bank.payment.file.exchange.mapper.DiscountMapper;
import org.bank.payment.file.exchange.repository.DiscountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@AllArgsConstructor
public class DiscountServiceImpl implements  DiscountService{

    private final  DiscountMapper discountMapper;

    private final  DiscountRepository discountRepository;


    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        Discount discount = discountMapper.toDiscount(discountDTO);
        discount.setDateDiscount(new Date());
        discount = discountRepository.save(discount);
        return discountMapper.toDiscountDTO(discount);
    }

    @Override
    public DiscountDTO getDiscountByIdDiscount(String idDiscount) {
        Discount discount =  discountRepository.findById(idDiscount).orElseThrow(() -> new RuntimeException("Discount not found with ID: " + idDiscount));
        return discountMapper.toDiscountDTO(discount);
    }

}
