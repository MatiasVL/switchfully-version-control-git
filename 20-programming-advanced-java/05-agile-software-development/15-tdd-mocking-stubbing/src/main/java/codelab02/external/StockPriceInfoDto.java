package codelab02.external;

import java.math.BigDecimal;

/**
 * A Data Transfer Object (DTO)
 * There's no need to perform data encapsulation.
 * A DTO object is a simple data carrier (put data in -> transport -> pull data out),
 * hence we can simply use public fields (although we could've created getters as well)
 */
public class StockPriceInfoDto {

    public BigDecimal price;
    public String stockId;
    public String currency;

    public StockPriceInfoDto(BigDecimal price, String stockId, String currency) {
        this.price = price;
        this.stockId = stockId;
        this.currency = currency;
    }
}
