import java.util.Base64;
import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // создаем экземпляр считывателя stdin
        System.out.println("Please enter you full name");
        String fullName = sc.nextLine(); // считываем очередную строку stdin (sc)
        String encodedFullName = Base64.getEncoder().encodeToString(fullName.getBytes());
        System.out.println("Program result: " + encodedFullName);
    }
}