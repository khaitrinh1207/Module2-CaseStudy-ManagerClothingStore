package Model;

import java.time.LocalDate;

public abstract class Clothes{
    private String code;
    private String name;
    private String color;
    private String brand;
    private double price;
    private LocalDate releaseDate;



    public Clothes() {
    }

    public Clothes(String code, String name, String color, String brand, double price,LocalDate releaseDate) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }




    @Override
    public String toString() {
        return "[code:" + code+
                "] [name:" + name+
                "] [color:" + color +
                "] [brand:" + brand +
                "] [price:" + price+
                "] [release date:"+releaseDate;
    }
}
