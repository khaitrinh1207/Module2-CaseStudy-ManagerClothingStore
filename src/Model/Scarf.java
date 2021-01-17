package Model;

import java.time.LocalDate;

public class Scarf extends Clothes {
    private final String designs;
    private final String fabric;

    public Scarf(String code, String name, String color, String brand, double price, LocalDate releaseDate, String designs, String fabric) {
        super(code, name, color, brand, price, releaseDate);
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
