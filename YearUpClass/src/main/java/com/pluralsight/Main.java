package com.pluralsight;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // 1. Send the GET request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.thecatapi.com/v1/images/search"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // 2. Very simple parsing (not robust but works for known structure)
        int urlStart = json.indexOf("\"url\":\"") + 7;
        int urlEnd = json.indexOf("\"", urlStart);
        String imageUrl = json.substring(urlStart, urlEnd);

        // 3. Print image URL
        System.out.println("Random cat image: " + imageUrl);

        // 4. (Optional) Open in browser (on supported systems)
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop.getDesktop().browse(new URI(imageUrl));
        }



        Person person = new Person("Jane", "Doe", "jane.doe@example.com", "female");
        Student student = new Student(
                101,                                // ID
                "Brian",                            // First name
                "Vega-Solano",                      // Last name
                "brianvs@example.com",              // Email
                "male",                             // Gender
                "https://github.com/BrianVegaSol",  // GitHub link
                "https://www.linkedin.com/in/brianvs/", // LinkedIn profile
                "Crash n' Burn",                    // Coding nickname
                "0",                                // Codewars XP (as String)
                "img/Avatar_Student_Male.jpg",      // Image URL
                "Windows",                          // Device type
                0,                                  // Workbook page number
                "81"                                // Currently working on (page/task)
        );
    }
}