package Model;

public class Scarf extends Clothes{
    private String designs;
    private String fabric;

    public Scarf() {
    }

    public Scarf(String code, String name, String color, String brand, double price, String designs, String fabric) {
        super(code, name, color, brand, price);
        this.designs = designs;
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "Scarf { " +
                super.toString()+
                "][designs:" + designs +
                "][fabric:" + fabric +
                "] }";
    }
}
