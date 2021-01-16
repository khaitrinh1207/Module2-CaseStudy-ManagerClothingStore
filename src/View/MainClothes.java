package View;

import Model.*;
import Service.ManagerClothes;

import java.util.Arrays;
import java.util.Scanner;

public class MainClothes {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ManagerClothes manager = new ManagerClothes();
        while (true) {
            System.out.println("--------------Quản lý thời trang--------------");
            System.out.println("Nhập 1: Hiển thị danh sách hiện có");
            System.out.println("Nhập 2: Thêm trang phục");
            System.out.println("Nhập 3: Xóa trang phục");
            System.out.println("Nhập 4: Sắp xếp theo giá");
            System.out.println("Nhập 5: Hàng mới về");
            System.out.println("Nhập 0: Thoát");
            System.out.println("----------------------------------------------");
            int change = Integer.parseInt(sc.nextLine());
            switch (change) {
                case 1:
                    manager.show();
                    break;
                case 2: {
                    System.out.println("Nhập mã sản phẩm");
                    String code = sc.nextLine();
                    String CODE_REGEX = "^[[A][O]|[Q][N]|[K][H]|[K][I]]{2}-[\\d]+$";
                    if (code.matches(CODE_REGEX)) {
                        String type = code.substring(0,2);
                        manager.add(infomation(type, code));
                    } else {
                        System.err.println("Cú pháp không hợp lệ !!!");
                    }
                }
                break;
                case 3:
                    System.out.print("Nhập vị trí muốn xóa:");
                    int index = sc.nextInt();
                    manager.remove(index);
                    break;
                case 0: {
                    return;
                }
                default:
                    System.err.println("Sai cú pháp !");

            }
        }
    }

    public static Clothes infomation(String type, String code) {
        System.out.print("Nhập tên sản phẩm:");
        String name = sc.nextLine();
        System.out.print("Nhập màu sắc:");
        String color = sc.nextLine();
        System.out.print("Nhập nhãn hiệu:");
        String brand = sc.nextLine();
        System.out.print("Nhập giá tiền:");
        double price = sc.nextDouble();
        sc.nextLine();
        if (type.equals("AO")) {
            return new Shirt(code,name,color,brand,price);
        } else if (type.equals("QN")) {
            return new Pants(code,name,color,brand,price);
        } else if (type.equals("KI")) {
            System.out.print("Nhập tròng kính:");
            String lens = sc.nextLine();
            return new Spectacles(code,name,color,brand,price,lens);
        } else if (type.equals("KH")) {
            System.out.print("Nhập kiểu dáng:");
            String design = sc.nextLine();
            System.out.print("Nhập chất liệu");
            String fabric = sc.nextLine();
            return new Scarf(code,name,color,brand,price,design,fabric);
        } else
            return null;
    }
}
