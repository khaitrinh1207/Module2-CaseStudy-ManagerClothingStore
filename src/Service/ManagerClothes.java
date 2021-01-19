package Service;

import Model.Clothes;
import Stoge.ReadAndWrite;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerClothes {
    public static final double DISCOUNT_50 = 0.5;
    public static final double DISCOUNT_20 = 0.8;
    List<Clothes> clothesList;

    public ManagerClothes() {
        clothesList = new ArrayList<>();
    }

    public void add(Clothes clothes) {
        clothesList.add(clothes);
        writeFile();
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

    public void discount(int month) {
        for (Clothes clothes : clothesList) {
            if (clothes.getReleaseDate().isBefore(LocalDate.now().minusMonths(month)) || clothes.getReleaseDate().isEqual(LocalDate.now().minusMonths(month))) {
                clothes.setPrice(clothes.getPrice() * DISCOUNT_50);
                System.out.print("[ SALE 50% ]\t");
                System.out.println(clothes);
            }
            if (LocalDate.now().isEqual(LocalDate.of(2021, 1, 20)) || LocalDate.now().isAfter(LocalDate.of(2021, 1, 15))) {
                clothes.setPrice(clothes.getPrice() * DISCOUNT_20);
                System.out.print("[ SALE 20% ]\t");
                System.out.println(clothes);
            }
        }
    }

    public void findNameProduct(String name) {
        Clothes findClothes = null;
        for (Clothes clothes : clothesList) {
            if (name.equalsIgnoreCase(clothes.getName())) {
                findClothes = clothes;
                System.out.println(findClothes);
            }
        }
        if(findClothes == null) {
            System.err.println("Không tìm thấy sản phẩm !!!");
        }
    }

    public void show() {
        System.out.println("[Số lượng sản phẩm: "+clothesList.size()+"]");
        if (clothesList.size() == 0) {
            System.err.println("Danh sách rỗng !!!");
        }
        else {
            for (Clothes clothes : clothesList) {
                System.out.println(clothes);
            }
        }
    }

    public void writeFile(){
        ReadAndWrite.write(clothesList);
    }

    public void readFile(){
        clothesList =(List<Clothes>) ReadAndWrite.read();
    }

}
