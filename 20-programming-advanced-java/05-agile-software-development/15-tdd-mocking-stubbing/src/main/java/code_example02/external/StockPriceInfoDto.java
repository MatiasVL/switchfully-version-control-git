package code_example02.external;

import java.math.BigDecimal;

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
