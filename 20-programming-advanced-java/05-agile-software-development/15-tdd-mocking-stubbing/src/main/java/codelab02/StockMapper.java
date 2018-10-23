package codelab02;

import codelab02.domain.Price;
import codelab02.domain.Stock;
import codelab02.external.StockPriceInfoDto;

import java.util.Optional;

/**
 * Read the README.md.
 * These is 1 public method (API) you should test (both branches (if/else) should be unit tested)
 */
public class StockMapper {

    public Optional<Stock> mapToStock(StockPriceInfoDto stockPriceInfo) {
        if (stockPriceInfo == null) {
            return Optional.empty();
        }
        return Optional.of(
                new Stock(
                        new Price(stockPriceInfo.currency, stockPriceInfo.price),
                        stockPriceInfo.stockId,
                        stockPriceInfo.stockId.toLowerCase()
                ));
    }

}
