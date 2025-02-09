package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringHandler {

    static void processStrings(List<String> fileContents, WorkMode workMode) {
        List<String> integers = new ArrayList<>();
        List<String> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        sort(fileContents, integers, floats, strings);


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

    static void sort(List<String> fileContents, List<String> integers, List<String> floats, List<String> strings) {
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
}
