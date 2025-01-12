package tictactoe;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "_________";
        char player1 = 'X';
        char player2 = 'O';
        char currentPlayer = player2;

        HashMap<Character, Integer> count = new HashMap<>();
        count.put('X', 0);
        count.put('O', 0);
        count.put('_', 0);


        while (!decideWinner(count, input)) {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;

            printField(input, count);
            input = checkForLegalMove(scanner, input, currentPlayer);




        }



    }

    private static String checkForLegalMove(Scanner scanner, String input, char currentPlayer) {
        boolean cellOccupation = false;
        while (true) {
            System.out.println("Enter your move (row and column separated by a space):");
            String nextInput = scanner.nextLine();

            if (!nextInput.matches("^[1-3] [1-3]$")) {
                System.out.println("You should enter numbers in the format 'row column'!");
                continue;
            }

            String[] coordinates = nextInput.split(" ");
            int xCoordinate = Integer.parseInt(coordinates[0]) - 1; // Convert to 0-based index
            int yCoordinate = Integer.parseInt(coordinates[1]) - 1; // Convert to 0-based index

            int index = xCoordinate * 3 + yCoordinate;
            if (input.charAt(index) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            StringBuilder sb = new StringBuilder(input);
            sb.setCharAt(index, currentPlayer);
            input = sb.toString();

            break;
        }
        return input;
    }


    private static boolean decideWinner(HashMap<Character, Integer> count, String input) {

        boolean gameOver = false;
        if (count.get('X') - count.get('O') > 1 || count.get('X') - count.get('O') < -1) {
            System.out.print("Impossible");
        }
        count.put('X', 0);
        count.put('O', 0);
        if (input.charAt(0) == input.charAt(1) && input.charAt(1) == input.charAt(2)) {
            count.put(input.charAt(0), count.get(input.charAt(0)) + 1);
        }
        if (input.charAt(3) == input.charAt(4) && input.charAt(4) == input.charAt(5)) {
            count.put(input.charAt(3), count.get(input.charAt(3)) + 1);
        }
        if (input.charAt(6) == input.charAt(7) && input.charAt(7) == input.charAt(8)) {
            count.put(input.charAt(6), count.get(input.charAt(6)) + 1);
        }
        if (input.charAt(0) == input.charAt(3) && input.charAt(3) == input.charAt(6)) {
            count.put(input.charAt(0), count.get(input.charAt(0)) + 1);
        }
        if (input.charAt(1) == input.charAt(4) && input.charAt(4) == input.charAt(7)) {
            count.put(input.charAt(1), count.get(input.charAt(1)) + 1);
        }
        if (input.charAt(2) == input.charAt(5) && input.charAt(5) == input.charAt(8)) {
            count.put(input.charAt(2), count.get(input.charAt(2)) + 1);
        }
        if (input.charAt(0) == input.charAt(4) && input.charAt(4) == input.charAt(8)) {
            count.put(input.charAt(0), count.get(input.charAt(0)) + 1);
        }
        if (input.charAt(2) == input.charAt(4) && input.charAt(4) == input.charAt(6)) {
            count.put(input.charAt(2), count.get(input.charAt(2)) + 1);

        }


        if ((count.get('X') > 0 && count.get('O') > 0) || count.get('X') > 1 || count.get('O') > 1) {
            System.out.print("Impossible");
        } else if (count.get('X') == 1) {
            printField(input, count);
            System.out.print("X wins");
            return true;
        } else if (count.get('O') == 1) {
            printField(input, count);
            System.out.print("O wins");
            return true;
        }
        else if(!input.contains("_")){
            printField(input, count);
            System.out.println("Draw");
            return true;
        }

        return gameOver;
    }


    public static void printField(String input, HashMap<Character, Integer> count) {

        String upperBarrier = "------------";
        String sideBarrier = "| ";
        System.out.println(upperBarrier);
        for (int i = 0; i <= 2; i++) {
            System.out.print(sideBarrier);
            for (int j = 0; j <= 2; j++) {
                char nextField = input.charAt(i * 3 + j);
                count.put(nextField, count.get(nextField) + 1);
                System.out.print(nextField + " ");
            }
            System.out.println(sideBarrier);
        }
        System.out.println(upperBarrier);
    }
}
