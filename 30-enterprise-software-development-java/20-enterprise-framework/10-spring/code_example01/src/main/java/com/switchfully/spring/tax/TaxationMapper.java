package com.switchfully.spring.tax;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class TaxationMapper {

    public List<TaxationDto> toDto(List<Taxation> taxationList) {
        return taxationList.stream().map(this::toDto).collect(toList());
    }

    public TaxationDto toDto(Taxation taxation) {
        return new TaxationDto(
                taxation.getFullName(),
                taxation.getBrutoIncome(),
                taxation.getNetIncome(),
                taxation.getTaxes(),
                taxation.getDueDate()
        );
    }

}
