package com.pluralsight;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

//        try {
//            int result = 12 / 0;  //  This will throw an ArithmeticException
//            System.out.println("Result: " + result);
//        } catch (ArithmeticException e) {
//            System.out.println("⚠ Oops! You can't divide by zero.");
//           // e.printStackTrace(); //Show the steps that lead to an error
//        }
//        System.out.println(" Program continues after handling the error.");
//        String[] names = {
//                "Ezra", "Elisha", "Ian",
//                "Siddalee", "Pursalane", "Zephaniah"
//        };

        boolean success = false;
        int correctNumber = (int)(Math.random() * 10) + 1;
        while (!success) {
            try {
                System.out.print("Pick a number (between #1 - #10): ");
                int guessedNumber = scanner.nextInt();
                scanner.nextLine(); // clear newline

                if (guessedNumber < 1 || guessedNumber > 10) {
                    System.out.println(" Number out of range. Pick between 1 and 10.");
                    continue;
                }
                if(guessedNumber != correctNumber) {
                    if(guessedNumber > correctNumber) {
                        System.out.println("It's to high");
                    }
                    if(guessedNumber < correctNumber )  {
                        System.out.println("its to low");
                    }
                    System.out.println("Wrong, try it again");
                    continue;
                }

                System.out.println("You guessed it correct ");
                success = true;

            } catch (InputMismatchException e) {
                System.out.println(" Not a valid number. Please enter digits only.");
                scanner.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("⚠ Something else went wrong: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }
    }
