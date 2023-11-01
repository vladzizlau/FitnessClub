package by.pvt.core.service;

import by.pvt.core.domain.Discounts;
import by.pvt.core.repository.interfaces.InterfaceDbDiscounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
 public class DiscountService implements IDiscount {

    @Autowired
    private InterfaceDbDiscounts interfaceDbDiscounts;


    public Discounts addDiscount(Discounts discount) {
       return interfaceDbDiscounts.save(discount);
    }

    public List<Discounts> getAll() {
        return interfaceDbDiscounts.findAll();
    }

    public void delete(Discounts discounts)
    {
        interfaceDbDiscounts.delete(discounts);
    }

    public Discounts getById(Long id){
        Optional<Discounts> discount = Optional.of(interfaceDbDiscounts.findById(id)).orElseThrow();
        return discount.get();
    }



}
