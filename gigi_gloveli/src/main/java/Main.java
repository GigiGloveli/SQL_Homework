import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


        ProductUtil.createTable();

        ProductUtil.insert(new Product("audi A8", 15000.0, 300, false));
        ProductUtil.insert(new Product("porche cayman S", 30000.0, 1500, true));
        ProductUtil.insert(new Product("jigul 08", 700.0, 15, true));
        ProductUtil.insert(new Product("zil", 1684.0, 450, false));
        ProductUtil.insert(new Product("gelik", 52344.0, 750, false));
        ProductUtil.insert(new Product("shevrolet cammaro", 15442.0, 1300, false));


        ProductUtil.countProducts();

        System.out.println(ProductUtil.read());

        ProductUtil.updatePrice(1, 20.15);

        ProductUtil.deleteProduct(2);





    }
}