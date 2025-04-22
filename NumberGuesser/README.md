# 🎮 Guessing Game Plus (Java Edition)

Welcome to **Guessing Game Plus**, an enhanced Java console game designed to help you learn and apply core Java programming concepts — from input handling to file I/O and collections.

---

## 🚀 Features

- 🧑‍💻 Enter your name to track your personal score history
- 🎯 Guess a number between 1-10 (Easy) or 1-100 (Hard)
- 🧠 Hard mode includes a limit of 5 attempts
- 📈 Feedback for "too high" or "too low" guesses
- 📝 Saves each game session to a result file
- 🏆 Remembers your personal best score (lowest number of attempts)
- 💾 Loads and saves highscores to a file using `HashMap`
- 🗃 Uses `ArrayList` to store your guess history
- 📅 Logs timestamps using `LocalDateTime`

---

## 🗂 Project Structure

```text
src/
├── com/pluralsight/
│   ├── GuessingGamePlus.java     # Main launcher
│   ├── GameLogic.java            # Game logic controller
│   ├── Player.java               # Represents a player and their stats
│   └── ScoreManager.java         # File I/O and score tracking
