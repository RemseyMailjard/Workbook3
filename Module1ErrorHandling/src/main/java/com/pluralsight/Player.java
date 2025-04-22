package com.pluralsight;

import java.util.ArrayList;

public class Player {
    private String name;
    private int personalBest = Integer.MAX_VALUE;
    private ArrayList<Integer> guesses = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public int getPersonalBest() { return personalBest; }
    public void setPersonalBest(int score) { personalBest = score; }

    public void addGuess(int guess) {
        guesses.add(guess);
    }

    public ArrayList<Integer> getGuesses() {
        return guesses;
    }

    public void resetGuesses() {
        guesses.clear();
    }
}
