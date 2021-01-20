package View;


import Service.UserManipulation;

public class MainUser {
    static private final UserManipulation user = new UserManipulation();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----------------Khách hàng-----------------");
            System.out.println("[Nhập 1] Xem sản phẩm");
            System.out.println("[Nhập 2] Hiển thị sản phẩm trong giỏ");
            System.out.println("[Nhập 3] Ví");
            System.out.println("[Nhập 0] THOÁT");
            System.out.println("\n--------------------------------------------");
            try {
                int change = Integer.parseInt(MainClothes.sc.nextLine());
                switch (change) {
                    case 1:
                        user.show();
                        System.out.println("\n[THÊM VÀO GIỎ]");
                        user.addProductsToCart(getIndex());
                        break;
                    case 2: {
                        user.showProductsInCart();
                        System.out.println("\n[NHẬP 1] XÓA SẢN PHẨM");
                        System.out.println("[NHẬP 2] THANH TOÁN SẢN PHẨM");
                        change = Integer.parseInt(MainClothes.sc.nextLine());
                        switch (change) {
                            case 1:
                                user.deleteProductInCart(getIndex());
                                break;
                            case 2:
                                payment();
                                break;
                        }

                    }
                    break;
                    case 3: {
                        double wallet = user.getUser().getWallet().getMoney();
                        System.out.println("Số dư trong ví:" + wallet);
                        System.out.println("\n[Nạp tiền]");
                        double money = Integer.parseInt(MainClothes.sc.nextLine());
                        user.addMoney(money);
                    }
                    break;
                    case 0:
                        return;
                    default:
                        System.out.println();
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi cú pháp !!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int getIndex() {
        System.out.print("Nhập vị trí sản phẩm:");
        return Integer.parseInt(MainClothes.sc.nextLine());
    }

    private static void payment() {
        double checkMoney = user.getUser().getWallet().getMoney();
        double totalMoneyProduct = user.totalMoneyProduct();
        if (checkMoney >= totalMoneyProduct) {
            user.payment();
            System.out.println("\nThanh toán thành công. \t Cảm ơn quý khách\n");
        } else {
            System.err.println("Nạp tiền vào ví!!!");
            System.out.print("\nNhập số tiền:");
            double money = Integer.parseInt(MainClothes.sc.nextLine());
            user.getUser().getWallet().addMoney(money);
            payment();
        }
    }


}
