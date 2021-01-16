package Model;

public class Spectacles extends Clothes{
    private String lens;

    public Spectacles() {
    }

    public Spectacles(String code, String name, String color, String brand, double price, String lens) {
        super(code, name, color, brand, price);
        this.lens = lens;
    }

    @Override
    public String toString() {
        return "Spectacles { " +
                super.toString()+
                "][lens:" + lens+
               "] }";
    }
}
