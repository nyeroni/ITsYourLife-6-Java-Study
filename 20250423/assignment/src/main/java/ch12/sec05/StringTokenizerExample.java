package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String [] names = data1.split("&|,");

        for(String name : names){
            System.out.println(name);
        }

        System.out.println();

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/");

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
