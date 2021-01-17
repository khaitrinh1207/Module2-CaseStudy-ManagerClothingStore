package Model;

import java.time.LocalDate;

public class Shirt extends Clothes {

    public Shirt(String code, String name, String color, String brand, double price, LocalDate releaseDate) {
        super(code, name, color, brand, price, releaseDate);
    }


    @Override
    public String toString() {
        return "Shirt { " +
                super.toString()+
                "] }";
    }
}
