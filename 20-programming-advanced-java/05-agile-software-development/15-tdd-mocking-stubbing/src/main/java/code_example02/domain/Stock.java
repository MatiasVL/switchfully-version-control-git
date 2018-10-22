package code_example02.domain;

import java.util.Objects;

public class Stock {

    public Price price;
    public String stockId;
    public String company;

    public Stock(Price price, String stockId, String company) {
        this.price = price;
        this.stockId = stockId;
        this.company = company;
    }

    public Price getPrice() {
        return price;
    }

    public String getStockId() {
        return stockId;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(price, stock.price) &&
                Objects.equals(stockId, stock.stockId) &&
                Objects.equals(company, stock.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, stockId, company);
    }
}
