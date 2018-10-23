# StockService

We've provided a service class called the `StockService`. 
It's fully functioning, but not tested.
- Do notice that we haven't yet provided an implementation of the `ExternalStockPriceService`. 
You don't have to provide one yet.

## Unit tests
For practicing mocking and stubbing, create a test class `StockServiceTest` in which you
**unit test** the 1 public method of `StockService`.
- As this is a unit test of the `StockService` class, mock or stub any behavior of its dependencies.
- Since we've implemented the `StockService` using (constructor) dependency injection, you can quickly 
see all the dependencies the `StockService` has. Simply look at the different arguments its constructor has.

## Integration tests
For practicing writing an integration test (to test the integration between more than one unit), 
create a test class `StockServiceIntegrationTest` in which you test the full integration of `StockService` and
its dependencies. Again, write a test method for the 1 public method of `StockService`.
- Don't perform any mocking or stubbing, we want to test the full integration of all units / components.
- Before you can test the full integration, you'll have to provide an implementation of the `ExternalStockPriceService`.
Create a class named `NasdaqStockPriceService` (which you'll use in your integration test) that implements `ExternalStockPriceService` and contains the following code:
    ```java
    
        @Override
        public void connect() {
            System.out.println("Connected!");
        }
        
        @Override
        public StockPriceInfoDto fetchCurrentPrice(String stockId) {
            return new StockPriceInfoDto(new BigDecimal(Math.random()), stockId, "Euro");
        }
  
    ```

## Optional: Unit test the mapper
Since we have extracted the mapping behavior to a specific class called `StockMapper`, we can simply unit test 
its specific behavior. This would've been more difficult if the `displayStockDetails` method directly implemented this 
mapping behavior. However, now, the `displayStockDetails` method simply calls the `mapToStock` method of `StockMapper` on
which it has a dependency.