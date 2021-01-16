package Model;

public class Pants extends Clothes{
    public Pants() {
    }

    public Pants(String code, String name, String color, String brand, double price) {
        super(code, name, color, brand, price);
    }

    @Override
    public String toString() {
        return "Pants { " +
                super.toString()+
                "] }";
    }
}
