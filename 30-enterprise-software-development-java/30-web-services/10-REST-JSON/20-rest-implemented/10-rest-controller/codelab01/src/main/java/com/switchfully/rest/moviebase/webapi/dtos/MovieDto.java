package com.switchfully.rest.moviebase.webapi.dtos;

/**
 * DTOs are simple objects that should not contain any business logic but may contain get, set, serialization and
 * deserialization mechanisms for transferring data "over the wire" (e.g. HTTP)
 */
public class MovieDto {

    private String id;
    private String title;
    private String description;
    private int runtimeInSeconds;

    public String getId() {
        return id;
    }

    public MovieDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MovieDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getRuntimeInSeconds() {
        return runtimeInSeconds;
    }

    public MovieDto setRuntimeInSeconds(int runtimeInSeconds) {
        this.runtimeInSeconds = runtimeInSeconds;
        return this;
    }
}
