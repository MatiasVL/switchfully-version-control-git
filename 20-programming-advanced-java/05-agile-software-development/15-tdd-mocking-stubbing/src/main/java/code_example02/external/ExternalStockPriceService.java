package code_example02.external;

public interface ExternalStockPriceService {

    void connect();
    StockPriceInfoDto fetchCurrentPrice(String stockId);

}
