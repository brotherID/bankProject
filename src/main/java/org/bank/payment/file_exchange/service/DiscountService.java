package org.bank.payment.file_exchange.service;

import org.bank.payment.file_exchange.dtos.DiscountDTO;

public interface DiscountService {
    DiscountDTO createDiscount(DiscountDTO discountDTO);
    DiscountDTO  getDiscountByIdDiscount(String idDiscount);
}
