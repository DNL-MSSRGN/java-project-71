package hexlet.code;

import java.io.IOException;
import java.util.*;
import static hexlet.code.Diff.diff;

public class Stylish {
    public static String comparisonStylish(String pathToFile1, String pathToFile2) throws IOException {
        var diffMap = diff(pathToFile1, pathToFile2);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        for (var result : diffMap.entrySet()) {
            var info = result.getKey().split("\\.");
            var status = info[0];
            switch (status) {
                case "removed" -> {
                    var newKey = " - " + info[1];
                    resultMap.put(newKey, result.getValue());
                }
                case "same" -> {
                    var newKey = "   " + info[1];
                    resultMap.put(newKey, result.getValue());
                }
                case "added" -> {
                    var newKey = " + " + info[1];
                    resultMap.put(newKey, result.getValue());
                }
                case "updated" -> {
                    var newKey = " + " + info[1];
                    resultMap.put(newKey, result.getValue());
                }
                default -> {
                    System.out.println(info[0]);
                }
            }
        }
        List<String> toSort = new ArrayList<>();
        toSort.addAll(resultMap.keySet());
        toSort.sort((key1, key2) -> key1.substring(3).compareTo(key2.substring(3)));
        StringJoiner joiner = new StringJoiner("\n", "{\n", "\n}");
        for (String key : toSort) {
            String s = key + ": " + resultMap.get(key);
            joiner.add(s);
        }
        return joiner.toString();
    }
}
