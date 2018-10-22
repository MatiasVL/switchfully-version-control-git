package code_example02.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Objects;

public final class Price {

    private final String currency;
    private final BigDecimal value;

    public Price(String currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", NumberFormat.getCurrencyInstance().format(value), currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(currency, price.currency) &&
                Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }
}
