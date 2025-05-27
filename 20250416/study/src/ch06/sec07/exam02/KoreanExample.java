package ch06.sec07.exam02;

public class KoreanExample {

    public static void main(String[] args) {

        Korean k1 = new Korean("박자바","011225-1234567");
        Korean k2 = new Korean("김자바","930525-0654321");

        printKorea("k1",k1);
        System.out.println();
        printKorea("k2",k2);

    }

    public static void printKorea(String name, Korean korean){
        System.out.printf("%s.nation : %s\n",name,korean.nation);
        System.out.printf("%s.name : %s\n",name,korean.name);
        System.out.printf("%s.ssn : %s\n",name,korean.ssn);
    }
}
