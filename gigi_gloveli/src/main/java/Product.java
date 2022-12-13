public class Product {

    private long id;
    private String name;
    private double price;
    private int kubatura;
    private boolean empiatze_chqari;

    public Product() {
    }

    public Product(long id, String name, double price, int kubatura, boolean empiatze_chqari) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.kubatura = kubatura;
        this.empiatze_chqari = empiatze_chqari;
    }

    public Product(String name, double price, int kubatura, boolean empiatze_chqari) {
        this.name = name;
        this.price = price;
        this.kubatura = kubatura;
        this.empiatze_chqari = empiatze_chqari;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getkubatura() {
        return kubatura;
    }

    public void setkubatura(int kubatura) {
        this.kubatura = kubatura;
    }

    public boolean isempiatze_chqari() {
        return empiatze_chqari;
    }

    public void setempiatze_chqari(boolean empiatze_chqari) {
        this.empiatze_chqari = empiatze_chqari;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", kubatura=" + kubatura +
                ", empiatze_chqari=" + empiatze_chqari +
                '}';
    }
}
