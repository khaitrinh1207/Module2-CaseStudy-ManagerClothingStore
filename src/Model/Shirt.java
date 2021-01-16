package Model;

public class Shirt extends Clothes{
    public Shirt() {
    }

    public Shirt(String code, String name, String color, String brand, double price) {
        super(code, name, color, brand, price);
    }

    @Override
    public String toString() {
        return "Shirt { " +
                super.toString()+
                "] }";
    }
}
