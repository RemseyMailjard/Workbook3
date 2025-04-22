package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("--------------------------------------");
        System.out.println("Choose a difficulty:");
        System.out.println("1. Easy (1 - 10)");
        System.out.println("2. Hard (1 - 100, only 5 tries)");

        int maxRange = 10;
        int maxAttempts = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Enter 1 or 2: ");
            try {
                int mode = scanner.nextInt();
                scanner.nextLine(); // clear newline
                if (mode == 1) {
                    maxRange = 10;
                    break;
                } else if (mode == 2) {
                    maxRange = 100;
                    maxAttempts = 5;
                    break;
                } else {
                    System.out.println(" Invalid choice. Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠ Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }

        int correctNumber = (int) (Math.random() * maxRange) + 1;
        boolean guessedCorrectly = false;
        int attempts = 0;

        System.out.println("\n🎯 I have picked a number between 1 and " + maxRange + ". Try to guess it!");

        while (!guessedCorrectly && attempts < maxAttempts) {
            try {
                System.out.print("Your guess: ");
                int guessedNumber = scanner.nextInt();
                scanner.nextLine(); // clear newline
                attempts++;

                if (guessedNumber < 1 || guessedNumber > maxRange) {
                    System.out.println("❌ Out of range! Try again.");
                    continue;
                }

                if (guessedNumber < correctNumber) {
                    System.out.println(" Too low!");
                } else if (guessedNumber > correctNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("  guessed it in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    break;
                }

                if (maxAttempts != Integer.MAX_VALUE) {
                    System.out.println("💡 Attempts left: " + (maxAttempts - attempts));
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠ Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }

        if (!guessedCorrectly) {
            System.out.println("😞 Out of attempts! The correct number was: " + correctNumber);
        }

        System.out.println("👋 Thanks for playing!");
        scanner.close();
    }
}
