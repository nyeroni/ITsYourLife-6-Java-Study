package ch18.sec11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/temp/images");
        File file1 = new File("/Users/temp/file1.txt");
        File file2 = new File("/Users/temp/file2.txt");
        File file3 = new File("/Users/temp/file3.txt");

        if(!dir.exists()) {
            dir.mkdir();
        }
        if(!file1.exists()) {
            file1.createNewFile();
        }
        if(!file2.exists()) {
            file2.createNewFile();
        }
        if(!file3.exists()) {
            file3.createNewFile();
        }

        File temp = new File("/Users/temp");
        File[] contents = temp.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        for(File file : contents) {
            System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
            if(file.isDirectory()) {
                System.out.printf("%-10s%-20s", "<DIR>", file.getName());
            } else {
                System.out.printf("%-10s%-20s", file.length(), file.getName());
            }
            System.out.println();
        }
    }
}
