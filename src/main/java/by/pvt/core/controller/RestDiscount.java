package by.pvt.core.controller;

import by.pvt.core.domain.Discounts;
import by.pvt.core.dto.DiscountRequest;
import by.pvt.core.dto.DiscountResponse;
import by.pvt.core.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
@RequiredArgsConstructor
public class RestDiscount {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/addsale")
    public String addSale(DiscountRequest request) {
        request.setClient_status("Active");
        discountService.addDiscount(request);

        return "Sale add ok";
    }

    @GetMapping("/getall")
    public List<DiscountResponse> getAll() {
        return discountService.getAll();
    }

    @PostMapping("/del={id}")
    public String delete(@PathVariable("id") Long id) {
        discountService.delById(id);
        return "Deleted: " + id;
    }

    @PostMapping("/update")
    public void update(DiscountRequest request) {
        discountService.update(request);
    }


}


