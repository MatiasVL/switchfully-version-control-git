package com.switchfully.rest.moviebase.webapi;

import com.switchfully.rest.moviebase.webapi.dtos.CreateMovieDto;
import com.switchfully.rest.moviebase.webapi.dtos.MovieDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MovieControllerIntegrationTest {

    @Value("${server.port}")
    private int port;

    @Test
    void createMovie_givenAMovieToCreate_thenTheNewlyCreatedMovieIsSavedAndReturned() {
        CreateMovieDto createMovieDto = new CreateMovieDto()
                .setTitle("Kill Bill")
                .setDescription("A nice movie for the whole family")
                .setRuntimeInSeconds(7820);

        MovieDto movieDto =
                RestAssured
                        .given()
                        .body(createMovieDto)
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .post("/movies")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(MovieDto.class);

        assertThat(movieDto.getId()).isNotBlank();
        assertThat(movieDto.getTitle()).isEqualTo(createMovieDto.getTitle());
        assertThat(movieDto.getDescription()).isEqualTo(createMovieDto.getDescription());
        assertThat(movieDto.getRuntimeInSeconds()).isEqualTo(createMovieDto.getRuntimeInSeconds());
    }

}
