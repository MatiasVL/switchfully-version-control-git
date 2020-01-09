package com.switchfully.spring.tax;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "taxes")
public class TaxController {

    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping(produces = "application/json", path = "{id}")
    public TaxationDto tax(@PathVariable("id") int id, @PathParam("income") int income){
        return taxService.calculateTax(id, income);
    }
}
