package ch06.심화.sec01;

public class DatabaseExample {
    public static void main(String []args) {
        Database db1 = Database.getInstance();
        String connection = db1.connect();
        System.out.println("데이터베이스: " + connection);
        db1.close();
    }
}
