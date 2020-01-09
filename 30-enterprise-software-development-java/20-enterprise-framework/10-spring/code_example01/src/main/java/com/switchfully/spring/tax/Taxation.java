package com.switchfully.spring.tax;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

import static java.time.LocalDate.now;

@Entity
@Table(name = "Tax")
public class Taxation {
    @Id
    private String id;
    private String fullName;
    private int brutoIncome;
    private double netIncome;
    private double taxes;
    private LocalDate dueDate;

    protected Taxation() {

    }

    public Taxation(String fullName, int brutoIncome, double netIncome, double taxes) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.brutoIncome = brutoIncome;
        this.netIncome = netIncome;
        this.taxes = taxes;
        this.dueDate = now().plusMonths(2);
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBrutoIncome() {
        return brutoIncome;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public double getTaxes() {
        return taxes;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
