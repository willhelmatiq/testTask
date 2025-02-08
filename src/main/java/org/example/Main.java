package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fileContents = new ArrayList<>();

        for (String arg : args) {
            try {
                // Read all lines from the file and add them to the list
                List<String> lines = Files.readAllLines(Paths.get(arg));
                fileContents.addAll(lines); // Merge lines from different files
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<String> integers = new ArrayList();
        List<String> floats = new ArrayList();
        List<String> strings = new ArrayList();

        sort(fileContents, integers, floats, strings);
        writeListToFile("integers.txt", integers);
        writeListToFile("floats.txt", floats);
        writeListToFile("strings.txt", strings);
    }


    static boolean isFloat(String currentString) {
        try {
            Double.parseDouble(currentString);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    static boolean isInteger(String currentString) {
        if (currentString.isEmpty()) {
            return false; // Handle null or empty case
        }
        for (char c : currentString.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    static void sort(List<String> fileContents, List<String> integers,  List<String> floats, List<String> strings) {
        for (String line : fileContents) {
            if (isInteger(line)) {
                integers.add(line);
            } else if (isFloat(line)) {
                floats.add(line);
            } else {
                strings.add(line);
            }
        }
    }

    public static void writeListToFile(String fileName, List<String> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : list) {
                writer.write(line);
                writer.newLine();  // Add a new line after each string
            }
            System.out.println("Written to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing file: " + fileName);
            e.printStackTrace();
        }
    }
}
