package Model;

import java.time.LocalDate;

public class Pants extends Clothes {

    public Pants(String code, String name, String color, String brand, double price, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
    }

    @Override
    public String toString() {
        return "Pants { " +
                super.toString()+
                "] }";
    }
}
