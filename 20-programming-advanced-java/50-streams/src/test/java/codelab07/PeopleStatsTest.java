package codelab07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static codelab07.PeopleStats.getStats;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class PeopleStatsTest {

    private Person sara;
    private Person viktor;
    private Person eva;
    private List<Person> collection;

    @BeforeEach
    void setup(){
        sara = new Person("Sara", 4);
        viktor = new Person("Viktor", 40);
        eva = new Person("Eva", 42);
        collection = asList(sara, eva, viktor);
    }

    @Test
    void getStatsShouldReturnAverageAge() {
        assertThat(getStats(collection).getAverage())
                .isEqualTo((double)(4 + 40 + 42) / 3);
    }

    @Test
    void getStatsShouldReturnNumberOfPeople() {
        assertThat(getStats(collection).getCount())
                .isEqualTo(3);
    }

    @Test
    void getStatsShouldReturnMaximumAge() {
        assertThat(getStats(collection).getMax())
                .isEqualTo(42);
    }

    @Test
    void getStatsShouldReturnMinimumAge() {
        assertThat(getStats(collection).getMin())
                .isEqualTo(4);
    }

    @Test
    void getStatsShouldReturnSumOfAllAges() {
        assertThat(getStats(collection).getSum())
                .isEqualTo(40 + 42 + 4);
    }

}