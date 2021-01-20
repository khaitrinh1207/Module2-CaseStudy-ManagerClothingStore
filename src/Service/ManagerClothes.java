package Service;

import Model.Clothes;
import Stoge.ReadAndWrite;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerClothes {
    public static final double DISCOUNT_50 = 0.5;
    public static final double DISCOUNT_20 = 0.8;
    List<Clothes> clothesList;

    // hàm khởi tạo
    public ManagerClothes() {
        clothesList = new ArrayList<>();
    }

    // thêm sản phẩm
    public void add(Clothes clothes) {
        clothesList.add(clothes);
        writeFile();
    }

    // xóa sản phẩm
    public void remove(int index) {
        if (clothesList.size() > 0) {
            for (int i = 0; i < clothesList.size(); i++) {
                if (i == (index - 1)) {
                    clothesList.remove(i);
                    writeFile();
                }
            }
        } else if (index >= clothesList.size()) {
            System.err.println("Vị trí không tồn tại");
        } else
            System.err.println("Danh sách rỗng !!!");

    }

    // sắp xếp theo thứ tự tăng dần giá tiền
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

    // sắp xếp theo thứ tự ưu tiên ngày tháng
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

    // hiển thị sản phẩm giảm giá
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

    // tìm kiếm sản phẩm theo tên
    public void findNameProduct(String name) {
        Clothes findClothes = null;
        for (Clothes clothes : clothesList) {
            if (name.equalsIgnoreCase(clothes.getName())) {
                findClothes = clothes;
                System.out.println(findClothes);
            }
        }
        if (findClothes == null) {
            System.err.println("Không tìm thấy sản phẩm !!!");
        }
    }

    // hiển thị sản phẩm
    public void show() {
        int count = 1;
        System.out.println("[Số lượng sản phẩm: " + clothesList.size() + "]\n");
        if (clothesList.size() == 0) {
            System.err.println("Danh sách rỗng !!!");
        } else {
            for (Clothes clothes : clothesList) {
                System.out.print("[" + (count++) + "]\t");
                System.out.println(clothes);
            }
        }
    }

    // ghi file vào list
    public void writeFile() {
        ReadAndWrite.write(clothesList);
    }

    // lấy file từ file.dat
    public void readFile() {
        clothesList = (List<Clothes>) ReadAndWrite.read();
    }

}
