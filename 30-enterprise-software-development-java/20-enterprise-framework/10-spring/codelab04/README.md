# Spring Boot dependency injection

Create a new Maven project
- GroupId = `com.switchfully.springdi`
- ArtifactId = `spring-boot-dependency-injection`

## Create the following classes (same as codelab03)

(also read the extra requirements below)

- Create `TaxCalculator`
    - A `TaxCalculator` calculates the taxes based on a yearly income (provide a method for this)
    - For its calculation, a `TaxCalculator` uses a `TaxCalculation` instance.
        - Inject the `TaxCalculation` dependency (Constuctor Dependency Injection) 
- Create `TaxCalculation`
    - It offers a method which calculates the taxes based on a yearly income
    - There are 3 concrete `TaxCalculations`
        1. `AmericanTaxCalculation`
            - Tax rate of 18%, lump sum of 950  
            - Formule: `yearlyIncome * 0.18 + 950`        
        2. `BelgianTaxCalculation`
            - Tax rate of 45%
            - Formule: `yearlyIncome * 0.45`
        3. `FrenchTaxCalculation`
            - Tax rate of 48%
            - Formule: `yearlyIncome * 0.48`
            
## Extra Requirements (required)
         
- Write tests, and use Mocking
- Use **Spring Boot**

## Solution

A solution is provided on https://github.com/switchfully/spring-boot-dependency-injection
- Only check it out when you're completely finished.
- Don't if you're stuck. If you're stuck: ask questions!
