import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProductUtil {

    private ProductUtil(){
    }

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS PRODUCTS(" +
            "ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL," +
            "PRODUCT_NAME VARCHAR(30)," +
            "PRICE DOUBLE," +
            "KUBATURA INTEGER," +
            "EMPIATZE_CHQARI BOOLEAN)";


    public static void createTable() throws SQLException{
        try {
            JDBCConf.getStatement().executeUpdate(CREATE_TABLE);
            System.out.println("Table Created!");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void insert(Product product){

        String INSERT_TABLE = "INSERT INTO PRODUCTS(PRODUCT_NAME, PRICE, KUBATURA, empiatze_chqari) VALUES(" +
                "'"+ product.getName() + "' ," +
                        + product.getPrice() + "," +
                        ""+ product.getkubatura() +
                "," + product.isempiatze_chqari() +")";

        try {
            JDBCConf.getStatement().executeUpdate(INSERT_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inserted!");
    }

    public static void countProducts() throws SQLException{

        String COUNT = "SELECT PRODUCT_NAME, COUNT(*) FROM PRODUCTS GROUP BY PRODUCT_NAME";

        try {

            ResultSet result = JDBCConf.getStatement().executeQuery(COUNT);
            while (result.next()){
                System.out.println(result.getString("PRODUCT_NAME") + ": " + result.getInt(2));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Integer> read() throws SQLException{
        String SELECT = "SELECT * FROM PRODUCTS";

        String COUNT = "SELECT COUNT(*) FROM PRODUCTS";

        List<Product> products = new ArrayList<>();

        try {
            ResultSet resultSet = JDBCConf.getStatement().executeQuery(SELECT);

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong("ID"));
                product.setName(resultSet.getString("PRODUCT_NAME"));
                product.setkubatura(resultSet.getInt("KUBATURA"));
                product.setPrice(resultSet.getDouble("PRICE"));
                product.setempiatze_chqari(resultSet.getBoolean("EMPIATZE_CHQARI"));
                products.add(product);
            }

            ResultSet result = JDBCConf.getStatement().executeQuery(COUNT);
            int count1 = 0;
            while (result.next()){
                count1 += result.getInt(1);
            }

            int finalCount = count1;
            Map<String, Integer> productMap = products.stream().collect(Collectors.toMap((m) -> m.getName(), (m) -> finalCount, (oldValue, newValue) -> newValue, TreeMap::new));

            return productMap;

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static void updatePrice(long id, double price) throws SQLException{
        String  UPDATE = "UPDATE PRODUCTS SET PRICE =" + price + "WHERE ID = " + id;
        try {
            JDBCConf.getStatement().executeUpdate(UPDATE);
            System.out.println("Changed!");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void deleteProduct(long id) throws SQLException{
        String DELETE = "DELETE FROM PRODUCTS WHERE ID = " + id ;
        try {
            JDBCConf.getStatement().executeUpdate(DELETE);
            System.out.println("Deleted!");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
