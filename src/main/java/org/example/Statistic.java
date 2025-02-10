package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class Statistic {
    static String getSortStat(List<String> stringList) {
        return "количество элементов: " + stringList.size();
    }
    static String getIntegerFullStat(List<String> integers) {
        BigInteger minInt = new BigInteger(integers.getFirst());
        BigInteger maxInt = new BigInteger(integers.getFirst());
        BigInteger sum = BigInteger.ZERO;

        for (String str : integers) {
            BigInteger num = new BigInteger(str);
            if (num.compareTo(minInt) < 0) {
                minInt = num;
            }
            if (num.compareTo(maxInt) > 0) {
                maxInt = num;
            }
            sum = sum.add(num);
        }

        BigDecimal avgVal = new BigDecimal(sum)
                .divide(new BigDecimal(integers.size()), 10, RoundingMode.HALF_UP);

        return getSortStat(integers) + "\n" +
                "минимум: " + minInt + "\n" +
                "максимум: " + maxInt + "\n" +
                "сумма: " + sum + "\n" +
                "среднее: " + avgVal;
    }

    static String getFloatFullStat(List<String> floats) {
        double minFloat = Double.parseDouble(floats.getFirst());
        double maxFloat = Double.parseDouble(floats.getFirst());
        double sum = 0;
        double avgVal;

        for (String str : floats) {
            double num = Double.parseDouble(str);
            if (num < minFloat) {
                minFloat = num;
            }
            if (num > maxFloat) {
                maxFloat = num;
            }
            sum += num;
        }
        avgVal = sum / floats.size();
        return getSortStat(floats) + "\n" +
                "минимум: " + minFloat + "\n" +
                "максимум: " + maxFloat + "\n" +
                "сумма: " + sum + "\n" +
                "среднее: " + avgVal;
    }

    static String getStringFullStat(List<String> strings) {
        String minStr = strings.getFirst();
        String maxStr = strings.getFirst();
        for (String str: strings) {
            if (str.length() < minStr.length()) {
                minStr = str;
            }
            if (str.length() > maxStr.length()) {
                maxStr = str;
            }
        }
        return getSortStat(strings) + "\n" +
                "размер самой короткой строки: " + minStr.length() + "\n" +
                "размер самой длинной строки: " + maxStr.length();
    }
}
