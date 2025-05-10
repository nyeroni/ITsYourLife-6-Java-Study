package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try {
            byte[] array = {10, 20, 30};
            OutputStream os = new FileOutputStream("/Users/temp/test2.db");
            os.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
