package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLogic {
    private Player player;
    private Scanner scanner;
    private ScoreManager scoreManager;

    public GameLogic(Player player, Scanner scanner, ScoreManager scoreManager) {
        this.player = player;
        this.scanner = scanner;
        this.scoreManager = scoreManager;
    }

    public void play() {
        int maxRange = 10;
        int maxAttempts = Integer.MAX_VALUE;

        System.out.println("\nChoose difficulty:");
        System.out.println("1. Easy (1-10)");
        System.out.println("2. Hard (1-100, 5 tries)");

        while (true) {
            System.out.print("Enter 1 or 2: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    maxRange = 10;
                    break;
                } else if (choice == 2) {
                    maxRange = 100;
                    maxAttempts = 5;
                    break;
                } else {
                    System.out.println("❌ Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠ Enter a number.");
                scanner.nextLine();
            }
        }

        int secret = (int)(Math.random() * maxRange) + 1;
        int attempts = 0;
        boolean won = false;

        player.resetGuesses();
        System.out.println("🎯 I picked a number between 1 and " + maxRange + ".");

        while (attempts < maxAttempts) {
            try {
                System.out.print("Your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine();
                player.addGuess(guess);
                attempts++;

                if (guess < 1 || guess > maxRange) {
                    System.out.println("❌ Out of range.");
                    continue;
                }

                if (guess < secret) {
                    System.out.println("📈 Too low.");
                } else if (guess > secret) {
                    System.out.println("📉 Too high.");
                } else {
                    System.out.println("🎉 Correct in " + attempts + " attempts!");
                    won = true;
                    scoreManager.updateBestScore(player, attempts);
                    break;
                }

                if (maxAttempts != Integer.MAX_VALUE) {
                    System.out.println("💡 Attempts left: " + (maxAttempts - attempts));
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠ Not a number.");
                scanner.nextLine();
            }
        }

        if (!won) {
            System.out.println("😞 Out of attempts! The correct number was: " + secret);
        }

        scoreManager.saveResult(player, attempts, won);
    }
}
