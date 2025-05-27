package ch11.sec06;

public class AccountExample {
    public static void main(String[] args){
        Account account = new Account();
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        try {
            System.out.println("5000원 인출 시도");
            account.withdraw(5000);
            System.out.println("5000원 인출 성공");
            System.out.println("7000원 인출 시도");
            account.withdraw(7000);
            System.out.println("7000원 인출 성공");
        } catch (InnsufficientException e) {
            System.out.println(e.getMessage());
        }
    }
}
