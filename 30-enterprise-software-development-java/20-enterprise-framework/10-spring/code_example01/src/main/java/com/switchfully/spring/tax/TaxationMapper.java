package com.switchfully.spring.tax;

import org.springframework.stereotype.Component;

@Component
public class TaxationMapper {
    public TaxationDto toDto(Taxation taxation) {
        return new TaxationDto(taxation.getFullName(), taxation.getBrutoIncome(), taxation.getNetIncome(), taxation.getTaxes());
    }
}
