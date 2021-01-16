package Service;

import Model.Clothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerClothes {
    Scanner sc = new Scanner(System.in);
    List<Clothes> clothesList;

    public ManagerClothes() {
        clothesList = new ArrayList<>();
    }

    public void add(Clothes clothes){
        clothesList.add(clothes);
    }

    public void remove(int index){
        clothesList.remove(index);
    }

    public void checkCode(String code){
        String CODE_REGEX = "^[AO|QN|KH|KI]{2}-[\\d]+$";

    }

    public void show(){
        for (Clothes clothes:
             clothesList) {
            System.out.println(clothes);
        }
    }


}
