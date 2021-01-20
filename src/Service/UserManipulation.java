package Service;

import Model.Clothes;
import Model.User.User;
import Stoge.ReadAndWrite;

import java.util.List;

public class UserManipulation {
    List<Clothes> productList = (List<Clothes>) ReadAndWrite.read();
    User user;

    public User getUser() {
        return user;
    }
    // hàm khởi tạo

    public UserManipulation() {
        user = new User();
    }
    // hiển thí sản phẩm cửa hàng

    public void show() {
        for (Object i : productList) {
            System.out.println(i);
        }
    }
    // lựa chọn sản phẩm trong cửa hàng

    public Clothes selected(int index) {
        Clothes product = productList.get(index);
        return product;
    }
    // thêm sản phẩm vào giỏ hàng

    public void addProductsToCart(int index) {
        List<Clothes> cart = user.getCart().getList();
        cart.add(selected(index));
    }
    // hiển thị sản phẩm trong giỏ

    public void showProductsInCart() {
        List<Clothes> cart = user.getCart().getList();
        for (Clothes i : cart) {
            System.out.println(i);
        }
    }
    // xóa sản phẩm trong giỏ

    public void deleteProductInCart(int index) {
        List<Clothes> cart = user.getCart().getList();
        cart.remove(index);
    }
    //tổng tiền sản phẩm trong giỏ

    public double totalMoneyProduct() {
        double totalMoneyProduct = 0;
        List<Clothes> cart = user.getCart().getList();
        for (Clothes clothes : cart) {
            totalMoneyProduct += clothes.getPrice();
        }
        return totalMoneyProduct;
    }

    // thanh toán sản phẩm
    public double payment() {
        double moneyInWallet = user.getWallet().getMoney();
        double payment = moneyInWallet - totalMoneyProduct();
        user.getWallet().setMoney(payment);
        return user.getWallet().getMoney();
    }

    // nap tiền vào ví
    public void addMoney(double money) {
        double wallet = user.getWallet().addMoney(money);
    }
}

