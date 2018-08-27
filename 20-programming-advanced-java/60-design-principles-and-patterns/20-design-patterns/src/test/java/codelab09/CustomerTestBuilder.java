package codelab09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CustomerTestBuilder {

    public static final String NAME = "Gregroire";
    private String name = NAME;
    private List<Rental> rentals = new ArrayList<>();

    private CustomerTestBuilder() {
    }

    public static CustomerTestBuilder customer() {
        return new CustomerTestBuilder();
    }

    public Customer build() {
        Customer result = new Customer(name);
        for (Rental rental : rentals) {
            result.addRental(rental);
        }
        return result;
    }

    public CustomerTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerTestBuilder withRentals(Rental... rentals) {
        Collections.addAll(this.rentals, rentals);
        return this;
    }

}