package code_example02;

import code_example02.domain.Price;
import code_example02.domain.Stock;
import code_example02.external.ExternalStockPriceService;
import code_example02.external.StockPriceInfoDto;

import java.util.Optional;

public class StockService {

    private final ExternalStockPriceService externalStockPriceService;

    public StockService(ExternalStockPriceService externalStockPriceService) {
        this.externalStockPriceService = externalStockPriceService;
    }

    public Optional<Stock> displayStockDetails(String stockId) {
        externalStockPriceService.connect();
        StockPriceInfoDto stockPriceInfo = externalStockPriceService.fetchCurrentPrice(stockId);
        return mapToStock(stockPriceInfo);
    }

    private Optional<Stock> mapToStock(StockPriceInfoDto stockPriceInfo) {
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
