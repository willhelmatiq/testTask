package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static WorkMode readFlags(String[] args) {
        String outputPath = "";
        String prefix = "";
        boolean appendMode = false;
        boolean statistic = false;
        boolean fullStatistic = false;

        List<String> arguments = Arrays.asList(args);

        for (int i = 0; i < arguments.size(); i++) {
            String arg = arguments.get(i);

            switch (arg) {
                case "-a":
                    appendMode = true;
                    break;
                case "-s":
                    statistic = true;
                    break;
                case "-f":
                    fullStatistic = true;
                    break;
                case "-p":
                    if (i + 1 < arguments.size()) {
                        prefix = arguments.get(i + 1);
                        i++; // Пропускаем следующий аргумент, так как он уже использован
                    }
                    break;
                case "-o":
                    if (i + 1 < arguments.size()) {
                        outputPath = arguments.get(i + 1);
                        i++; // Пропускаем следующий аргумент, так как он уже использован
                    }
                    break;
                default:
                    // Игнорируем входные файлы (они идут без флагов)
                    if (arg.startsWith("-")) {
                        System.out.println("Неизвестный флаг: " + arg);
                    }
                    break;
            }
        }

        return new WorkMode(outputPath, prefix, appendMode, statistic, fullStatistic);
    }

    public static List<String> getInputFilesList(String[] args) {
        List<String> inputFiles = new ArrayList<>();

        int fileStartIndex = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (args[i].equals("-o") || args[i].equals("-p")) {
                    i++; // Пропускаем следующий аргумент
                }
            } else {
                // Нашли первый файл
                fileStartIndex = i;
                break;
            }
        }
        for (int i = fileStartIndex; i < args.length; i++) {
            inputFiles.add(args[i]);
        }
        return inputFiles;
    }
}
