
import com.github.lucassalesmoreira.core.query.Query;
import com.github.lucassalesmoreira.core.query.select.SelectQuery;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;


// this.queryBuilder
//      .find("user")
//      .columns("id", "name", "year", "created_at")
//      .where()
//      .equal("document", "13385479430")
//      .or()
//      .notEqual("year", 18)
//      .build();

public class MainTest {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    @Test
    void test1() {
        Query myQuery = new SelectQuery()
                .find("user")
                .columns("id", "name", "year", "created_at")
                .build();
        this.logger.info(myQuery.toString());
    }
}
