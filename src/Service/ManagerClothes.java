package Service;

import Model.Clothes;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerClothes {
    List<Clothes> clothesList;
    public static final String FILE_NAME = "dataClothes.dat";

    public ManagerClothes() {
        clothesList = new ArrayList<>();
    }

    public void add(Clothes clothes) {
        clothesList.add(clothes);
    }

    public void remove(int index) {
        if (clothesList.size() > 0) {
            for (int i = 0; i < clothesList.size(); i++) {
                if (i == index) {
                    clothesList.remove(i);
                    writeFile();
                }
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
            if (i.getReleaseDate().isAfter(LocalDate.now().minusMonths(1))) {
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

    public void discount() {
        for (Clothes clothes : clothesList) {
            if (clothes.getReleaseDate().isBefore(LocalDate.now().minusMonths(6)) || clothes.getReleaseDate().isEqual(LocalDate.now().minusMonths(6))) {
                clothes.setPrice(clothes.getPrice() * 0.5);
                System.out.print("[ SALE 50% ]\t");
                System.out.println(clothes);
            }
            if (LocalDate.now().isEqual(LocalDate.of(2021, 1, 20)) || LocalDate.now().isAfter(LocalDate.of(2021, 1, 15))) {
                clothes.setPrice(clothes.getPrice() * 0.8);
                System.out.print("[ SALE 20% ]\t");
                System.out.println(clothes);
            }
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

    public void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clothesList);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readFile() {
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream oos = new ObjectInputStream(fis);
            clothesList = (List<Clothes>) oos.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
