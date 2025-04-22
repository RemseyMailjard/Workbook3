package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScoreManager {
    private static final String SCORE_FILE = "highscores.txt";
    private HashMap<String, Integer> scores = new HashMap<>();

    public void loadScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    scores.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("📁 No existing score file. Starting fresh.");
        }
    }

    public void saveScores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE))) {
            for (String name : scores.keySet()) {
                writer.write(name + "," + scores.get(name));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠ Error writing scores.");
        }
    }

    public void loadPlayerBest(Player player) {
        if (scores.containsKey(player.getName())) {
            player.setPersonalBest(scores.get(player.getName()));
            System.out.println("👋 Welcome back " + player.getName() + "! Best score: " + player.getPersonalBest() + " attempts.");
        } else {
            System.out.println("🆕 Hello " + player.getName() + "! Good luck!");
        }
    }

    public void updateBestScore(Player player, int attempts) {
        if (attempts < player.getPersonalBest()) {
            player.setPersonalBest(attempts);
            scores.put(player.getName(), attempts);
            System.out.println("🏆 New personal best!");
        }
    }

    public void saveResult(Player player, int attempts, boolean won) {
        String fileName = "game_result_" + player.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.write("Game played on " + dtf.format(LocalDateTime.now()));
            writer.newLine();
            writer.write("Result: " + (won ? "Win" : "Lose") + " in " + attempts + " attempts");
            writer.newLine();
            writer.write("Guesses: " + player.getGuesses());
            writer.newLine();
            writer.write("--------------------------------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("⚠ Could not save result file.");
        }
    }
}
