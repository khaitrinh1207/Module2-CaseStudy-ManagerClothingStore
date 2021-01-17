package Service;

import Model.Clothes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerClothes {
    List<Clothes> clothesList;

    public ManagerClothes() {
        clothesList = new ArrayList<>();
    }

    public void add(Clothes clothes) {
        clothesList.add(clothes);
    }

    public void remove(int index) {
        if (clothesList.size() > 0) {
            for (int i = 0; i < clothesList.size(); i++) {
                if (i == index)
                    clothesList.remove(i);
            }
        } else
            System.err.println("Danh sách rỗng !!!");
    }

    public void sortLowToUp() {
        clothesList.sort(((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice())
                return 1;
            if (o1.getPrice() < o2.getPrice())
                return -1;
            else return 0;
        }));
        show();
    }

    public void newClothes() {
        List<Clothes> newClothes = new ArrayList<>();
        for (Clothes i : clothesList) {
            if ( i.getReleaseDate().isAfter(LocalDate.now().minusMonths(1))){
                newClothes.add(i);
            }
        }
        newClothes.sort(((o1, o2) -> {
            if (o1.getReleaseDate().isBefore(o2.getReleaseDate()))
                return 1;
            if (o1.getReleaseDate().isAfter(o2.getReleaseDate()))
                return -1;
            else return 0;
        }));
        for (Clothes clothes : newClothes) {
            System.out.println(clothes);
        }
    }

    public void show() {
        if (clothesList.size() == 0)
            System.err.println("Danh sách rỗng !!!");
        else {
            for (Clothes clothes : clothesList) {
                System.out.println(clothes);
            }
            System.out.print("Số lượng thời trang hiện có: ");
            System.out.println(clothesList.size());
        }
    }


}
