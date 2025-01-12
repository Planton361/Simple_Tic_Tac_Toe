import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int input = scanner.nextInt();

        input = (input/ 10) %10;
        System.out.println(input);
    }
}