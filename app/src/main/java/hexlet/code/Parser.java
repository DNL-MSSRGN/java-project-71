package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
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

    @SuppressWarnings("checkstyle:RegexpSingleline")
    public static Map<String, Object> parser(String pathToFile) throws IOException {
        var file = Files.readString(normalizeAbsolutePath(pathToFile));
        var format = formatName(pathToFile);
        ObjectMapper map = null;

        switch (format) {
            case "json" -> {
                map = new ObjectMapper();
            }
            case "yml" -> {
                map = new YAMLMapper();
            }
            default -> {
                System.out.println("Illegal format:" + format);
            }
        }

        Map<String, Object> stringObjectMap = map.readValue(file, new TypeReference<Map<String, Object>>() {
        });
        return stringObjectMap;

    }
}
