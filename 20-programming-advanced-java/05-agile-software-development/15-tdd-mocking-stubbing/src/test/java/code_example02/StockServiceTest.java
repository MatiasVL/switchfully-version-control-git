package code_example02;

import code_example02.domain.Price;
import code_example02.domain.Stock;
import code_example02.external.ExternalStockPriceService;
import code_example02.external.StockPriceInfoDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Unit tests for the StockService, using Mockito for mocking and stubbing behavior of ExternalStockPriceService which
 * the StockService uses heavily.
 *
 * Fun fact: ExternalStockPriceService is an interface for which we don't yet have any implementing class. Yet, we can
 * fully (and independently) test the behavior of StockService.
 */
class StockServiceTest {

    private StockService stockService;
    private ExternalStockPriceService externalStockPriceServiceMock;

    @BeforeEach
    void setupStockService() {
        externalStockPriceServiceMock = Mockito.mock(ExternalStockPriceService.class);
        stockService = new StockService(externalStockPriceServiceMock);
    }

    /**
     * A Unit test written using Mockito to verify that method connect of ExternalStockPriceService is called (just once)
     */
    @Test
    void displayStockDetails_givenAStockId_thenConnectWithExternalStockPriceService() {
        final String stockId = "APPLE";

        stockService.displayStockDetails(stockId);

        Mockito.verify(externalStockPriceServiceMock).connect();
    }

    /**
     * A Unit test written using Mockito to verify that method connect is called before calling method fetchCurrentPrice
     * of ExternalStockPriceService (both should be called just once)
     */
    @Test
    void displayStockDetails_givenAStockId_thenFirstlyConnectAndThenFetchTheCurrentPriceUsingTheExternalStockPriceService() {
        final String stockId = "APPLE";

        stockService.displayStockDetails(stockId);

        InOrder expectedLogicalExecutionFlow = Mockito.inOrder(externalStockPriceServiceMock);
        expectedLogicalExecutionFlow.verify(externalStockPriceServiceMock).connect();
        expectedLogicalExecutionFlow.verify(externalStockPriceServiceMock).fetchCurrentPrice(stockId);
    }

    /**
     * A Unit test written using Mockito to stub the fetchCurrentPrice method of ExternalStockPriceService
     * By stubbing the fetchCurrentPrice method, we can assert the actual result returned by method displayStockDetails
     */
    @Test
    void displayStockDetails_givenAStockId_thenReturnAStock() {
        final String stockId = "APPLE";
        Mockito.when(externalStockPriceServiceMock.fetchCurrentPrice(stockId))
                .thenReturn(new StockPriceInfoDto(BigDecimal.TEN, stockId, "Euro"));

        Optional<Stock> actualStock = stockService.displayStockDetails(stockId);

        Assertions.assertThat(actualStock.get())
                .isEqualTo(new Stock(new Price("Euro", BigDecimal.TEN), stockId, stockId.toLowerCase()));
    }

    /**
     * A Unit test written using Mockito to stub the fetchCurrentPrice method of ExternalStockPriceService
     * By stubbing the fetchCurrentPrice method, we can assert the actual result returned by method displayStockDetails
     */
    @Test
    void displayStockDetails_givenAnUnknownStockId_thenReturnAnEmptyStockOptional() {
        final String stockId = "APPLE";
        Mockito.when(externalStockPriceServiceMock.fetchCurrentPrice(stockId))
                .thenReturn(null);

        Optional<Stock> actualStock = stockService.displayStockDetails(stockId);

        Assertions.assertThat(actualStock.isPresent()).isFalse();
    }

}