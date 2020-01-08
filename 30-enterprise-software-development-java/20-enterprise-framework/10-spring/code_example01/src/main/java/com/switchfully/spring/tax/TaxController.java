package com.switchfully.spring.tax;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "taxes")
public class TaxController {

    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping(produces = "text/plain", path = "{id}")
    public String tax(@PathVariable("id") int id){
        return "" + taxService.calculateTax(id);
    }
}
