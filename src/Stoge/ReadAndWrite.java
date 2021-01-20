package Stoge;

import java.io.*;

public class ReadAndWrite {
    public static final String FILE_NAME = "dataClothes.dat";

    public static void write(Object obj) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(obj);
            oos.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read() {
        Object obj = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("Dữ liệu rỗng !!!");
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj;
    }
}