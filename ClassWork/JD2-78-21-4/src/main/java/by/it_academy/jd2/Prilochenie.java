package by.it_academy.jd2;

import by.it_academy.jd2.serves.NameView;

import java.util.ArrayList;
import java.util.Scanner;

public class Prilochenie {
    public static void main(String[] args) {
        System.out.println("Введите имена");
        System.out.println("Для выхода введи exit");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
         NameView nameView = new NameView();
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("exit")) {
                break;
            }
            nameView.add(s);
        }
        System.out.println(nameView.getAll());
    }
}


