package org.bank.payment.file.exchange.service;

import org.bank.payment.file.exchange.dtos.DiscountDTO;

public interface DiscountService {
    DiscountDTO createDiscount(DiscountDTO discountDTO);
    DiscountDTO  getDiscountByIdDiscount(String idDiscount);
}
