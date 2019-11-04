package codelab01.switchtothesun.attraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttractionRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AttractionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Attraction> getAllAttractions() {
        return jdbcTemplate.query("YOUR QUERY HERE", (row, rowNum) -> new Attraction(row.getString("name")));
    }
}
