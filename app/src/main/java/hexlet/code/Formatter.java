package hexlet.code;

import java.io.IOException;

import static hexlet.code.formatters.Plain.comparisonPlain;
import static hexlet.code.formatters.Stylish.comparisonStylish;

public class Formatter {
    public static String formatter(String pathToFile1, String pathToFile2, String format) throws IOException {
        var result = "";
        switch (format) {
            case "stylish" -> {
                result += comparisonStylish(pathToFile1, pathToFile2);
            }
            case "plain" -> {
                result += comparisonPlain(pathToFile1, pathToFile2);
            }
            default -> {
                System.out.println("Illegal format:" + format);
            }
        }
        return result;
    }
}
