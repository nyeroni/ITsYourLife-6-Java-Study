package ch09.sec07.exam03;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOK = new Button();

        btnOK.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");            }
        });
        btnOK.click();

        Button btnCancel = new Button();

        btnOK.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Cancel 버튼을 클릭했습니다.");            }
        });
        btnOK.click();
    }
}
