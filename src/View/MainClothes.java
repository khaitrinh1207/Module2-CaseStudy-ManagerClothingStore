package View;

import Model.*;
import Service.ManagerClothes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainClothes {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ManagerClothes manager = new ManagerClothes();
        manager.readFile();
        while (true) {
            System.out.println("--------------CỬA HÀNG THỜI TRANG--------------");
            System.out.println("Nhập 1: Hiển thị danh sách hiện có");
            System.out.println("Nhập 2: Thêm trang phục");
            System.out.println("Nhập 3: Xóa trang phục");
            System.out.println("Nhập 4: Sắp xếp theo giá");
            System.out.println("Nhập 5: Tìm kiếm sản phẩm theo tên");
            System.out.println("Nhập 6: Hàng mới về");
            System.out.println("Nhập 7: >>> [SALE] <<<");
            System.out.println("Nhập 0: Thoát");
            System.out.println("----------------------------------------------");
            int change = Integer.parseInt(sc.nextLine());
            switch (change) {
                case 1:
                    manager.show();
                    break;
                case 2:
                    addProduct(manager);
                    break;
                case 3:
                    System.out.print("Nhập vị trí muốn xóa:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    manager.remove(index);
                    break;
                case 4:
                    manager.sortLowToUp();
                    break;
                case 5:
                    System.out.println("Nhập sản phẩm cần tìm:");
                    String name = sc.nextLine();
                    manager.findNameProduct(name);
                    break;
                case 6:
                    manager.newClothes();
                    break;
                case 7:
                    manager.discount();
                    break;
                case 0: {
                    return;
                }
                default:
                    System.err.println("Sai cú pháp !");


            }
        }
    }

    private static void addProduct(ManagerClothes manager) {
        System.out.println("Nhập mã sản phẩm");
        String code = sc.nextLine();
        String CODE_REGEX = "^(AO|QN|KH|KI)-[\\d]+$";
        if (code.matches(CODE_REGEX)) {
            String type = code.substring(0, 2);
            manager.add(infomation(type, code));
            manager.writeFile();
        } else {
            System.err.println("Cú pháp không hợp lệ !!!");
        }
    }

    private static Clothes infomation(String type, String code) {
        System.out.print("Nhập tên sản phẩm:");
        String name = sc.nextLine();
        System.out.print("Nhập màu sắc:");
        String color = sc.nextLine();
        System.out.print("Nhập nhãn hiệu:");
        String brand = sc.nextLine();
        System.out.print("Nhập giá tiền:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ngày lên kệ:");
        String rd = sc.nextLine();
        LocalDate releaseDate = LocalDate.parse(rd, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        switch (type) {
            case "AO":
                return new Shirt(code, name, color, brand, price, releaseDate);
            case "QN":
                return new Pants(code, name, color, brand, price, releaseDate);
            case "KI":
                System.out.print("Nhập tròng kính:");
                String lens = sc.nextLine();
                return new Spectacles(code, name, color, brand, price, releaseDate, lens);
            case "KH":
                System.out.print("Nhập kiểu dáng:");
                String design = sc.nextLine();
                System.out.print("Nhập chất liệu:");
                String fabric = sc.nextLine();
                return new Scarf(code, name, color, brand, price, releaseDate, design, fabric);
            default:
                return null;
        }
    }
}
