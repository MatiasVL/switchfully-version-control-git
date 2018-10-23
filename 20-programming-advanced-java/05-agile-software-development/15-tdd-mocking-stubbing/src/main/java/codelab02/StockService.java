package codelab02;

import codelab02.domain.Stock;
import codelab02.external.ExternalStockPriceService;
import codelab02.external.StockPriceInfoDto;

import java.util.Optional;

/**
 * Read the README.md.
 * These is 1 public method (API) you should test
 */
public class StockService {

    private final ExternalStockPriceService externalStockPriceService;
    private final StockMapper stockMapper;

    public StockService(ExternalStockPriceService externalStockPriceService, StockMapper stockMapper) {
        this.externalStockPriceService = externalStockPriceService;
        this.stockMapper = stockMapper;
    }

    public Optional<Stock> displayStockDetails(String stockId) {
        externalStockPriceService.connect();
        StockPriceInfoDto stockPriceInfo = externalStockPriceService.fetchCurrentPrice(stockId);
        return stockMapper.mapToStock(stockPriceInfo);
    }
}
