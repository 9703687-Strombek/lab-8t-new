package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Завдання 1 - MyOptional ===");
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

        System.out.println("\n=== Завдання 3 - Printer ===");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        System.out.println("\n=== Завдання 4 - filter (метод) ===");
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(filter(numbers, n -> n % 2 == 0)));
        String[] words = {"java", "c", "python", "go"};
        System.out.println(Arrays.toString(filter(words, w -> w.length() > 2)));

        System.out.println("\n=== Завдання 5 contains (метод) ===");
        System.out.println(contains(words, "go"));
        System.out.println(contains(words, "rust"));
        System.out.println(contains(numbers, 7));
        System.out.println(contains(numbers, 70));

        System.out.println("\n=== Завдання 6 ===");
        // тут я навожу приклад просто рейтингу
        GenericTwoTuple<String, Integer> two = new GenericTwoTuple<>("Іванов", 95);
        System.out.println("Студент: " + two.first + ", рейтинг: " + two.second);
        System.out.println(two);
        // тут я навожу приклад середнього балу
        GenericThreeTuple<String, Integer, Double> three = new GenericThreeTuple<>("Петренко", 88, 10.5);
        System.out.println(three);
        System.out.println(three.getFirst() + " " + three.getSecond() + " " + three.three);
    }

    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T item : input) {
            if (p.test(item)) {
                result[counter] = item;
                counter++;
            }
        }

        T[] trimmed = (T[]) new Object[counter];
        for (int i = 0; i < counter; i++) {
            trimmed[i] = result[i];
        }
        return trimmed;
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}


