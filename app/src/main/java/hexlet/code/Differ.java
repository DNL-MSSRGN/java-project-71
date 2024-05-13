package hexlet.code;


import java.io.IOException;
import static hexlet.code.Stylish.comparisonStylish;

public class Differ {


    public static String  generate(String pathToFile1, String pathToFile2, String format) throws IOException {
        var result = "";
        switch (format) {
            case "stylish" -> {
                result += comparisonStylish(pathToFile1, pathToFile2);
            }
            default -> {
                System.out.println("Illegal format:" + format);
            }
        }
        return result;
    }
}
