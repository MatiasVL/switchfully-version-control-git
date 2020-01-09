package com.switchfully.spring.tax;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "taxes")
public class TaxController {

    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping(produces = "application/json", path = "{id}")
    public TaxationDto taxSimulation(@PathVariable("id") int id, @PathParam("income") int income){
        return taxService.taxSimulation(id, income);
    }

    @GetMapping(produces = "application/json")
    public List<TaxationDto> allTaxes(){
        return taxService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "text/plain", path = "{id}")
    public TaxationDto tax(@PathVariable("id") int id, @RequestBody String income){
        return taxService.tax(id, Integer.parseInt(income));
    }
}
