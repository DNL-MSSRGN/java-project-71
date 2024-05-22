package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Formatter.formatter;

public class Differ {

    public static Path normalizeAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }
    private static String formatName(String filePath) {
        String[] extArray = filePath.split("\\.");
        if (extArray.length > 0) {

            return extArray[extArray.length - 1];
        } else {
            return "";
        }
    }


    public static String  generate(String pathToFile1, String pathToFile2, String format) throws Exception {
        var file1 = Files.readString(normalizeAbsolutePath(pathToFile1));
        var file2 = Files.readString(normalizeAbsolutePath(pathToFile2));
        var formatFile1 = formatName(pathToFile1);
        var formatFile2 = formatName(pathToFile2);
        return formatter(file1, file2, format, formatFile1, formatFile2);
    }
    public static String generate(String pathToFile1, String pathToFile2) throws Exception {
        return generate(pathToFile1, pathToFile2, "stylish");
    }
}
