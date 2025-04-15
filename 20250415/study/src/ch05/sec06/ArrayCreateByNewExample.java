package ch05.sec06;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {
        int[] arr1 = new int[3];

        for(int i=0; i<3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println();

        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        for(int i=0; i<3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println();
        String[] arr3 = new String[3];
        for(int i=0; i<3; i++) {
            System.out.print("arr3[" + i + "] : " + arr3[i] + ", ");
        }
        System.out.println();
        arr3[0] = "hi";
        arr3[1] = "hello";
        arr3[2] = "bye";
        for(int i=0; i<3; i++) {
            System.out.print("arr3[" + i + "] : " + arr3[i] + ", ");
        }
    }
}
