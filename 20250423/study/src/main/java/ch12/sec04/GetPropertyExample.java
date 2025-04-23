package ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String username = System.getProperty("user.name");
        String home = System.getProperty("user.home");

        System.out.println("운영체제 명 : " + osName);
        System.out.println("로그인 사용자 명 : " + username);
        System.out.println("홈 디렉토리 : " + home);

        System.out.println("시스템 속성 정보 전체 출력");
        Properties props = System.getProperties();
        Set keys = props.keySet();

        for (Object objKey : keys) {
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.printf("%-40s: %s\n", key, value);
        }

    }
}
