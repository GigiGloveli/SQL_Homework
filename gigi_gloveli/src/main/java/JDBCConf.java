import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final  class JDBCConf{

    public static final String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7584497";
    public static final String DB_USER = "sql7584497";
    public static final String DB_PASSWORD = "r2ezFm6y9c";

    private static Connection connection;
    private static Statement statement;

    private JDBCConf() {

    }

    static {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Statement getStatement() {
        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }


}
