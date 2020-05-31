package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeekDigitTask {

    public static void main(String[] args) {
        System.out.print("Please, enter your number where each digit is in range 1..7 inclusive: ");
        Scanner scanner = new Scanner(System.in);
        Integer number = null;

        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            if (number < 1) {
                System.out.print("Invalid number.");
                System.exit(0);
            }
        } else {
            System.out.print("Invalid number.");
        }

        int length = 0;
        long temp = 1;
        while (temp <= number) {
            length++;
            temp *= 10;
        }

        int mod = 10;
        int div = 1;
        StringBuilder result = new StringBuilder();
        String currentSeparator = "";
        String lastSeparator = "";
        int last = 0;
        for (int i = 0; i < length; i++) {
            int digit = number % mod / div;
            if (digit < 1 || digit > 7) {
                System.out.println("Invalid number.");
                System.exit(0);
            } else {
                if (i != 0) {
                    currentSeparator = last - digit == 1 ? "-" : ",";
                    if (currentSeparator.equals(",")) {
                        if (lastSeparator.equals("-"))
                            result.append(lastSeparator + last);
                        result.append(currentSeparator + digit);
                    } else if (i + 1 == length) {
                        result.append(currentSeparator + digit);
                    }
                } else {
                    result.append(digit);
                }

            }
            last = digit;
            lastSeparator = currentSeparator;
            mod *= 10;
            div *= 10;
        }

        System.out.println("Result -> " + result.reverse().toString());

    }
}
