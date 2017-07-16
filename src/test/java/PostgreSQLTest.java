import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * description.
 *
 * @author Haneul, Kim
 */
public class PostgreSQLTest {

    @Test
    public void connect() throws SQLException {
        String url = "jdbc:postgresql://mdw.phd.local:5432/oozie";
        Connection conn = DriverManager.getConnection(url, "oozie", "Change2#2$");
        Statement statement = conn.createStatement();
        boolean execute = statement.execute("select 1");
        System.out.println(execute);
        conn.close();
    }
}
