package hexlet.code;


import java.io.IOException;

import static hexlet.code.Formatter.formatter;

public class Differ {


    public static String  generate(String pathToFile1, String pathToFile2, String format) throws IOException {
        return formatter(pathToFile1, pathToFile2, format);
    }
}
