# Code example

## Purpose
Showing a use case for Spring by creating a simple full stack application

## Steps
- Create a rest resource
- Create beans
- Create connection to the database

## Concepts
- Technical classes: resources/services/repositories
- Functional classes: dom
- What is a resouce?
    - a java class that:
        - is stateless
        - provides an entrypoint for http calls
- What is service?
    - a java class that:
        - is stateless
        - delegates calls to domain objects
        - aggregates behaviour for one concept
- What is a repository?
    - a java class that:
        - is stateless
        - provides a technical link between an application and a database
