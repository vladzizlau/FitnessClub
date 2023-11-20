package by.pvt.core.mapper;

import by.pvt.core.domain.Discounts;
import by.pvt.core.dto.DiscountRequest;
import by.pvt.core.dto.DiscountResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMap {
    DiscountResponse toResponse(Discounts discounts);
    Discounts toEntity (DiscountRequest request);
    List<DiscountResponse> toResponseList(List<Discounts> discountsList);
}
