package com.pluralsight;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final String SCORE_FILE = "highscores.txt";
    static HashMap<String, Integer> playerScores = new HashMap<>();

    public static void main(String[] args) {
        loadScoresFromFile();

        System.out.println("🎮 Welcome to the Ultimate Guessing Game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        if (playerScores.containsKey(playerName)) {
            System.out.println("👋 Welcome back, " + playerName + "! Your best score is " + playerScores.get(playerName) + " attempts.");
        } else {
            System.out.println("🆕 New player detected. Good luck, " + playerName + "!");
        }

        int maxRange = 10;
        int maxAttempts = Integer.MAX_VALUE;

        System.out.println("\nChoose a difficulty:");
        System.out.println("1. Easy (1-10)");
        System.out.println("2. Hard (1-100, max 5 tries)");

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
                System.out.println("⚠ Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        int secretNumber = (int)(Math.random() * maxRange) + 1;
        ArrayList<Integer> guesses = new ArrayList<>();
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\n🎯 I have picked a number between 1 and " + maxRange + ".");

        while (attempts < maxAttempts && !guessedCorrectly) {
            try {
                System.out.print("Your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine();
                attempts++;
                guesses.add(guess);

                if (guess < 1 || guess > maxRange) {
                    System.out.println("❌ Out of range.");
                    continue;
                }

                if (guess < secretNumber) {
                    System.out.println("📈 Too low.");
                } else if (guess > secretNumber) {
                    System.out.println("📉 Too high.");
                } else {
                    System.out.println("🎉 Correct in " + attempts + " attempts!");
                    guessedCorrectly = true;

                    if (!playerScores.containsKey(playerName) || attempts < playerScores.get(playerName)) {
                        playerScores.put(playerName, attempts);
                        System.out.println("🏆 New personal best!");
                    }
                    break;
                }

                if (maxAttempts != Integer.MAX_VALUE) {
                    System.out.println("💡 Attempts left: " + (maxAttempts - attempts));
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠ Not a number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("⚠ Something went wrong: " + e.getMessage());
                scanner.nextLine();
            }
        }

        if (!guessedCorrectly) {
            System.out.println("😞 Out of attempts! The correct number was: " + secretNumber);
        }

        saveResultToFile(playerName, attempts, guessedCorrectly, guesses);
        saveScoresToFile();
        System.out.println("👋 Game over. Thanks for playing!");
    }

    private static void loadScoresFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    playerScores.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("📁 No existing score file. Starting fresh.");
        } catch (IOException e) {
            System.out.println("⚠ Could not read scores.");
        }
    }

    private static void saveScoresToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE))) {
            for (String name : playerScores.keySet()) {
                writer.write(name + "," + playerScores.get(name));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠ Error writing scores.");
        }
    }

    private static void saveResultToFile(String player, int attempts, boolean won, ArrayList<Integer> guesses) {
        String fileName = "game_result_" + player + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.write("Game played on " + dtf.format(LocalDateTime.now()));
            writer.newLine();
            writer.write("Result: " + (won ? "Win" : "Lose") + " in " + attempts + " attempt(s)");
            writer.newLine();
            writer.write("Guesses: " + guesses);
            writer.newLine();
            writer.write("--------------------------------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("⚠ Could not save game result.");
        }
    }
}