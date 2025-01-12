import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        // The first operation goes here
        input %= 2;
        System.out.println(input);
        input *= 3;
        System.out.println(input);
        // The second operation goes here

        scanner.close();
    }
}