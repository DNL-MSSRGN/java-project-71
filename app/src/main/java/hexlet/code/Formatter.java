package hexlet.code;


import static hexlet.code.Compairse.differ;
import static hexlet.code.Parser.parser;
import static hexlet.code.formatters.Json.buildJson;
import static hexlet.code.formatters.Plain.buildPlain;
import static hexlet.code.formatters.Stylish.buildStylish;

public class Formatter {
    public static String formatter(String pathToFile1, String pathToFile2, String format) throws Exception {
        var result = "";
        var map1 = parser(pathToFile1);
        var map2 = parser(pathToFile2);
        switch (format) {
            case "stylish" -> {
                result += buildStylish(differ(map1, map2));
            }
            case "plain" -> {
                result += buildPlain(differ(map1, map2));
            }
            case "json" -> {
                result += buildJson(differ(map1, map2));
            }
            default -> {
                System.out.println("Illegal format:" + format);
            }
        }
        return result;
    }

}
