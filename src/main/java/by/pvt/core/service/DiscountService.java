package by.pvt.core.service;

import by.pvt.core.domain.Discounts;
import by.pvt.core.dto.DiscountRequest;
import by.pvt.core.dto.DiscountResponse;
import by.pvt.core.mapper.SaleMap;
import by.pvt.core.repository.interfaces.InterfaceDbDiscounts;
import by.pvt.core.service.iface.IDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DiscountService implements IDiscount {

    private SaleMap saleMap;
    private InterfaceDbDiscounts interfaceDbDiscounts;

    @Autowired
    public DiscountService(SaleMap saleMap, InterfaceDbDiscounts interfaceDbDiscounts) {
        this.saleMap = saleMap;
        this.interfaceDbDiscounts = interfaceDbDiscounts;
    }

    public Discounts addDiscount(DiscountRequest request) {
        Discounts discounts = saleMap.toEntity(request);
        return interfaceDbDiscounts.save(discounts);
    }

    public List<DiscountResponse> getAll() {
        return saleMap.toResponseList(interfaceDbDiscounts.findAll());
    }

    public void delById(long id) {
        interfaceDbDiscounts.deleteById(id);
    }

    public Discounts getById(Long id) {
        Optional<Discounts> discount = Optional.of(interfaceDbDiscounts.findById(id)).orElseThrow();
        return discount.get();
    }

    public void update(DiscountRequest request) {
        interfaceDbDiscounts.save(saleMap.toEntity(request));
    }

}
