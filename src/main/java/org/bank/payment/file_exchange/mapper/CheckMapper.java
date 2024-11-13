package org.bank.payment.file_exchange.mapper;

import org.bank.payment.file_exchange.dtos.CheckDTO;
import org.bank.payment.file_exchange.entities.Check;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CheckMapper {

    @Mapping(source = "discount.idDiscount", target = "discountId")
    CheckDTO toCheckDTO(Check check);

    @Mapping(source = "discountId", target = "discount.idDiscount")
    Check toCheck(CheckDTO checkDTO);

}
