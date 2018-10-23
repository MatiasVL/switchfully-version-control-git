package codelab02.external;

/**
 * Read the README.md.
 */
public interface ExternalStockPriceService {

    void connect();
    StockPriceInfoDto fetchCurrentPrice(String stockId);

}
