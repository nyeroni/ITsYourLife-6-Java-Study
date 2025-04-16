package ch06.심화.sec02;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String read(String title) {
        System.out.print(title+": ");
        return scanner.nextLine();
    }

    public static String read(String title, String defaultValue) {
        System.out.print(title + "(" + defaultValue + "): ");
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

    public static int readInt(String title) {
        System.out.print(title+": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static boolean confirm(String title, boolean defaultValue) {
        String option = defaultValue ? "(Y/n): " : "(y/N): ";
        System.out.print(title + " " + option);
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.isEmpty()) return defaultValue;
        return input.equals("y") || input.equals("yes");
    }

    public static boolean confirm(String title) {
        return confirm(title, false);
    }
}
