package switchtothesun.metadata;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MetadataRepository {

    private JdbcTemplate jdbcTemplate;

    public MetadataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getNumberOfVisits(){
        return jdbcTemplate.query("select * from metadata", (row, rowNum) -> row.getInt("NUMBER_OF_VISITS")).get(0);
    }

    public void increaseNumberOfVisitsByOne() {
        jdbcTemplate.update("update METADATA set NUMBER_OF_VISITS = ?", getNumberOfVisits() + 1);
    }
}
