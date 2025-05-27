package ch07.sec10.exam01;

public class PhoneExample {
    public static void main(String[] args) {
//        Phone phone = new Phone(); 매개변수 존재하지 않음 !
        SmartPhone smartPhone = new SmartPhone("홍길동");
        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}
