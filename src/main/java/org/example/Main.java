package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.example.Utils.getInputFilesList;
import static org.example.Utils.readFlags;

public class Main {
    public static void main(String[] args) {
        WorkMode workMode = readFlags(args);
        List<String> inputFiles = getInputFilesList(args);
        List<String> fileContents = readFromInput(inputFiles);



        writeListToFile("integers.txt", integers);
        writeListToFile("floats.txt", floats);
        writeListToFile("strings.txt", strings);
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

    static List<String> readFromInput(List<String> inputFiles) {
        List<String> fileContents = new ArrayList<>();
        for (String arg : inputFiles) {
            try {
                // Read all lines from the file and add them to the list
                List<String> lines = Files.readAllLines(Paths.get(arg));
                fileContents.addAll(lines); // Merge lines from different files
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileContents;
    }
}
