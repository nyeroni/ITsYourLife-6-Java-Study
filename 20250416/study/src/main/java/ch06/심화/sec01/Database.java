package ch06.심화.sec01;

public class Database {
    private static Database instance;
    private String connection = "MySQL";

    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }
    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }
}
