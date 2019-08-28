package switchtothesun.country;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {

    private JdbcTemplate jdbcTemplate;

    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> getAllCountries(){
        return jdbcTemplate.query("select * from country", (row, rowNum) -> new Country(row.getString("name")));
    }

    public void addCountry(String parameter) {
        jdbcTemplate.update("insert into COUNTRY (ID, NAME) values (COUNTRY_SEQ.nextval, ?)", parameter);
    }

    public void delete(String parameter) {
        jdbcTemplate.update("delete from COUNTRY where name = ?", parameter);
    }
}
