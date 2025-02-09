package org.example;

import java.util.List;

public class Statistic {
    static String getSortStat(List<String> stringList) {
        return "количество элементов: " + stringList.size();
    }
    static String getIntegerFullStat(List<String> integers) {

    }

    static String getFloatFullStat(List<String> floats) {

    }

    static String getStringFullStat(List<String> strings) {
        String minStr = strings.get(0);
        String maxStr = strings.get(0);
        for (String str: strings) {
            if (str.length() < minStr.length()) {
                minStr = str;
            }
            if (str.length() > maxStr.length()) {
                maxStr = str;
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(getSortStat(strings)).append("\n");
        result.append("размер самой короткой строки: ").append(minStr.length());
        result.append("размер самой длинной строки: ").append(maxStr.length());
        return result.toString();
    }
}
