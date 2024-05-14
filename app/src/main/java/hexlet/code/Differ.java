package hexlet.code;

import static hexlet.code.Formatter.formatter;

public class Differ {


    public static String  generate(String pathToFile1, String pathToFile2, String format) throws Exception {
        return formatter(pathToFile1, pathToFile2, format);
    }
}
