# JPA simple queries

## Reporting
Change the reporting functionality so that it uses hibernate in it's calls.
1. First start by making `Attraction` a JPA entity
    1. Provide all necessary annotations to `Attraction` (@Table, @Entity, @Column, @Id)
    1. Put `@Transient` on the `country` field in `Attraction`. We'll later explain why.
    1. The field `country` will be temporally be null during this exercise. Make sure you don't get nullpointers! 
    1. Provide a default constructor.
    1. Add an entity-manager to the AttractionRepository
    1. Use the entity manager to get a list of Attractions
    1. Create a report. You should see a list of all the attractions without a country name
    
1. Now make sure that there is a link between `Attraction` and `Country`
    1. Change the `@Transient` with `@ManyToOne` and under it the line `@JoinColumn(name="FK_COUNTRY_ID")`
    1. `Attraction` will now have a link to `Country`. Easy wasn't it?
    1. Create a report. Country should again been filled in.
        1. Something will still be broken, but now you have the tools to fix it.