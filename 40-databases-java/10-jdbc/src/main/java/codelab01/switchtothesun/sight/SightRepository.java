package codelab01.switchtothesun.sight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SightRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sight> getAllSights() {
        return jdbcTemplate.query("select * from sight", (row, rowNum) -> new Sight(row.getString("name")));
    }
}
