package org.bank.payment.file.exchange.mapper;

import org.bank.payment.file.exchange.dtos.CheckDTO;
import org.bank.payment.file.exchange.entities.Check;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CheckMapper {

    @Mapping(source = "discount.idDiscount", target = "discountId")
    CheckDTO toCheckDTO(Check check);

    @Mapping(source = "discountId", target = "discount.idDiscount")
    Check toCheck(CheckDTO checkDTO);

}
