package ch09.sec06.exam03;

public class ButtonExample {
    public static void main(String[] args) {
        Button button = new Button();

        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("OK 버튼을 클릭했습니다.");
            }
        }
        button.setClickListener(new OkListener());
        button.click();
    }
}
