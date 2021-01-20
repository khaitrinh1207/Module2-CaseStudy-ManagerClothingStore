package Model.User;

import Model.Clothes;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Clothes> selected;

    public Cart() {
        selected = new ArrayList<>();
    }

    public List<Clothes> getList() {
        return selected;
    }
}
