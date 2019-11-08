# JPA simple queries

**Tips**:
- Artifact `spring-boot-starter-data-jpa` is already on the classpath (as a dependency): You will have all the required 
JPA and Hibernate classes, annotations,... at your disposal. 
- Refactor the code in `20-orm-jpa/src/main/java/switchtothesun` based on the requirements below.
- The `application.properties` (if stored inside `resources`) will be read in by a Spring Boot application by default.
- Look at the slides for links to additional resources **(!!)**

## Reporting
Change the reporting functionality so that it uses JPA (using Hibernate as the vendor) in its calls.
1. First start by making `Attraction` a JPA entity
    1. Provide all necessary annotations to `Attraction` (@Table, @Entity, @Column, @Id)
    1. Put `@Transient` on the `country` field in `Attraction`. We'll later explain why.
    1. The field `country` will temporally be null during this exercise. Make sure you don't get nullpointers! 
    1. Provide a default or no-arg constructor (JPA demands this, it can be private though).
    1. Inject an entityManager to the AttractionRepository using `@PersistenceContext`
    1. Use the entityManager to get a list of Attractions
    1. Create a report. You should see a list of all the attractions without a country name
    
1. Now make sure that there is a link between `Attraction` and `Country`
    1. Change the `@Transient` with `@ManyToOne` and under it the line `@JoinColumn(name="FK_COUNTRY_ID")`
    1. `Attraction` will now have a link to `Country`. Easy wasn't it?
    1. Create a report. Country should again been filled in.
        1. Something will most likely still be broken, but you should have the knowledge to fix it now...
