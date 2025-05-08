package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> products = ProductReader.readProductFromCSV("products.csv");
       for(Product p : products) {
           System.out.println(p.getName());
       }



//            // a specific file
//            FileInputStream fis = new FileInputStream("poem.txt");
//            // create a Scanner to reference the file to be read
//            Scanner scanner = new Scanner(fis);
//            String input;
//            // read until there is no more data
//            while(scanner.hasNextLine()) {
//                input = scanner.nextLine();
//                System.out.println(input);
//            }
//            // close the scanner and release the resources
//            scanner.close();
//        }
//        catch(IOException e) {
//            System.out.println("Can't find the file");
//            // display stack trace if there was an error
//          //  e.printStackTrace();
//        }


    }

//    public static void runFileReadExample() {
//        System.out.println("\\n File Reading Example:");
//        try (BufferedReader reader = new BufferedReader(new FileReader("demo_output.txt"))) {
//            String line = reader.readLine();
//            System.out.println("Read from file: " + line);
//        } catch (IOException e) {
//            System.out.println("⚠ Error reading from file.");
//        }
//    }



}