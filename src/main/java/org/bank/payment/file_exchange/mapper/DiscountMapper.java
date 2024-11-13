package org.bank.payment.file_exchange.mapper;

import org.bank.payment.file_exchange.dtos.DiscountDTO;
import org.bank.payment.file_exchange.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CheckMapper.class})
public interface DiscountMapper {

    // Mapping de Discount vers DiscountDTO
    @Mapping(target = "checks", source = "checks")
    DiscountDTO toDiscountDTO(Discount discount);

    // Mapping de DiscountDTO vers Discount
    @Mapping(target = "checks", source = "checks")
    Discount toDiscount(DiscountDTO discountDTO);
}
