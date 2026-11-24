package ua.opnu;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Завдання 1 ===");
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("Гетер: " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив нул: " + ex.getMessage());
        }




        System.out.println("\n=== Завдання 2: BookData ===");
        BookData[] books = {
                new BookData("Кобзар", "Тарас Шевченко", 10, 40),
                new BookData("Лісова пісня", "Леся Українка", 5, 25),
                new BookData("Захар Беркут", "Іван Франко", 4, 16),
                new BookData("Тореадори з Васюківки", "Всеволод Нестайко", 2, 10)
        };
        Arrays.sort(books);
        for (BookData b : books) {
            System.out.println(b);
        }



    }
}
