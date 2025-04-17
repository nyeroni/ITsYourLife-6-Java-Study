package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane airplane = new SupersonicAirplane();
        airplane.takeOff();
        airplane.fly();
        airplane.flyMode = SupersonicAirplane.SUPERSONIC;
        airplane.fly();
        airplane.flyMode = SupersonicAirplane.NORMAL;
        airplane.fly();
        airplane.land();
    }
}
