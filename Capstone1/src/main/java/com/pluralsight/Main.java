package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


        static final String CSV_FILE = "transactions.csv";

        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n==== Home Menu ====");
                System.out.println("D) Add Deposit");
                System.out.println("P) Make Payment");
                System.out.println("L) Ledger");
                System.out.println("X) Exit");
                System.out.print("Choose an option: ");
                String input = scanner.nextLine().trim().toUpperCase();

                switch (input) {
                    case "D":
                        addTransaction(scanner, true);
                        break;
                    case "P":
                        addTransaction(scanner, false);
                        break;
                    case "L":
                        showLedger(scanner);
                        break;
                    case "X":
                        System.out.println("Exiting application. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid input, try again.");
                }
            }
        }

        static void addTransaction(Scanner scanner, boolean isDeposit) throws IOException {
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Vendor: ");
            String vendor = scanner.nextLine();
            System.out.print("Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            if (!isDeposit) amount *= -1;

            String entry = String.format("%s|%s|%s|%s|%.2f",
                    LocalDate.now(),
                    LocalTime.now().withNano(0),
                    description,
                    vendor,
                    amount);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
                writer.write(entry);
                writer.newLine();
            }

            System.out.println("Transaction saved.");
        }

        static void showLedger(Scanner scanner) throws IOException {
            List<String[]> entries = readTransactions();
            Collections.reverse(entries);

            while (true) {
                System.out.println("\n==== Ledger Menu ====");
                System.out.println("A) All");
                System.out.println("D) Deposits");
                System.out.println("P) Payments");
                System.out.println("R) Reports");
                System.out.println("H) Home");
                System.out.print("Choose an option: ");
                String input = scanner.nextLine().trim().toUpperCase();

                switch (input) {
                    case "A":
                        displayEntries(entries);
                        break;
                    case "D":
                        displayEntries(entries.stream().filter(e -> Double.parseDouble(e[4]) > 0).collect(Collectors.toList()));
                        break;
                    case "P":
                        displayEntries(entries.stream().filter(e -> Double.parseDouble(e[4]) < 0).collect(Collectors.toList()));
                        break;
                    case "R":
                        showReports(scanner, entries);
                        break;
                    case "H":
                        return;
                    default:
                        System.out.println("Invalid input.");
                }
            }
        }

        static void showReports(Scanner scanner, List<String[]> entries) {
            System.out.println("\n==== Reports ====");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Choose a report: ");

            String input = scanner.nextLine().trim();
            // Logic voor rapporten hier toevoegen...
            System.out.println("Report functionality coming soon...");
        }

        static void displayEntries(List<String[]> entries) {
            for (String[] e : entries) {
                System.out.printf("%s %s | %-20s | %-15s | %10.2f\n", e[0], e[1], e[2], e[3], Double.parseDouble(e[4]));
            }
        }

        static List<String[]> readTransactions() throws IOException {
            List<String[]> transactions = new ArrayList<>();
            File file = new File(CSV_FILE);
            if (!file.exists()) return transactions;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    transactions.add(line.split("\\|"));
                }
            }
            return transactions;
        }
    }
