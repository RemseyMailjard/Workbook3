package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.io.*;     // This helps us read from files
import java.util.*;   // We use this to work with lists

public class ProductReader {


    // Methodname what do I return?
    // Write the return at the end
    public static List<Product> readProductFromCSV(String fileName) {

        List<Product> productList = new ArrayList<>();
        //
        // Pseudocode is breaking a problem down in steps
        // in plain English

        // Step 0 - Try/catch necessary
        try {
            // Open the file to read
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            // Skip the first line (it contains column names like id,name,price,stock)
            reader.readLine();

            String line;
            // Read each remaining line in the file

            //Step 1 Read the file
            while ((line = reader.readLine()) != null) {
                // Split the line into parts, using comma as the separator
                String[] parts = line.split(",");
               // parts[0];
                // Check if the line has exactly 4 parts (id, name, price, stock)
                if (parts.length == 4) {
                    // Step 2 - Store the data internally into variables
                    int id = Integer.parseInt(parts[0]);        // Convert the first part to an integer (ID)
                    String name = parts[1];                     // Get the name as text
                    double price = Double.parseDouble(parts[2]); // Convert price to a decimal number
                    int stock = Integer.parseInt(parts[3]);     // Convert stock to an integer
                    int abug = 10/0;
                    // Create a new Product object using the parts
                    Product p = new Product(id, name, price, stock);



                    // Add the product to the list

                    productList.add(p);
                    System.out.println(p.getName() + " was added to the list");
                }
            }

            // Close the reader when done
            reader.close();

        } catch (IOException e) {
            // Print an error message if the file can't be read
            System.out.println("Something went wrong while reading the file.");
           // e.printStackTrace();
        }
        // Step 1 - Read the file

        // Step 3 - Create a product


        return productList;
    }
}
