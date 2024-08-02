import com.github.lucassalesmoreira.core.query.Query;
import com.github.lucassalesmoreira.core.query.select.SelectQuery;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    @Test
    void test1() {
        var expectedQuery = "select id, name, year, created_at from user where document = '13385479430' or year != 18";

        Query myQuery = new SelectQuery()
                .find("user")
                .columns("id", "name", "year", "created_at")
                .where()
                .equal("document", "13385479430")
                .or()
                .notEqual("year", 18)
                .build();

        var generatedQueryString = myQuery.toString();
        assertEquals(expectedQuery, generatedQueryString);
        this.logger.info(generatedQueryString);
    }

    @Test
    void test2() {
        var expectedQuery = "select * from user where name = 'Lucas Sales' and year > 18";

        Query myQuery = new SelectQuery()
                .find("user")
                .where()
                .equal("name", "Lucas Sales")
                .and()
                .biggerThan("year", 18)
                .build();

        var generatedQueryString = myQuery.toString();
        assertEquals(expectedQuery, generatedQueryString);
        this.logger.info(generatedQueryString);
    }

    @Test
    void test3() {
        var expectedQuery = "select id, document, name from user where name = 'Lucas Sales' and year < 18";

        Query myQuery = new SelectQuery()
            .find("user")
            .columns("id", "document", "name")
            .where()
            .equal("name", "Lucas Sales")
            .and()
            .lessThan("year", 18)
            .build();

        var generatedQueryString = myQuery.toString();
        assertEquals(expectedQuery, generatedQueryString);
        this.logger.info(generatedQueryString);
    }
}
