package ru.job4j.files;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int total = str.trim().split("\\s+").length;
        System.out.println("Количество слов: " + total);
    }
}
