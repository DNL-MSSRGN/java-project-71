package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import static hexlet.code.Parser.parser;

public class Differ {

    @SuppressWarnings("checkstyle:RegexpSingleline")
    public static String generate(String pathToFile1, String pathToFile2) throws IOException {
        Map<String, Object> mapFile1 = parser(pathToFile1);
        Map<String, Object> mapFile2 = parser(pathToFile2);
        Map<String, Object> resultMap = new HashMap<>();

        for (var key : mapFile1.entrySet()) {
            if (!mapFile2.containsKey(key.getKey())) {
                String newKey = "- " + key.getKey();
                resultMap.put(newKey, key.getValue());
            }
            if (mapFile2.containsKey(key.getKey())
                    && mapFile2.get(key.getKey()).equals(key.getValue())) {
                String newKey = "  "  + key.getKey();
                resultMap.put(newKey, key.getValue());
            }
        }

        for (var key2 : mapFile2.entrySet()) {
            if (!mapFile1.containsKey(key2.getKey())) {
                String newKey = "+ " + key2.getKey();
                resultMap.put(newKey, key2.getValue());
            }
            if (mapFile1.containsKey(key2.getKey())
                    && !mapFile1.get(key2.getKey()).equals(key2.getValue()))  {
                String newKey = "- "  + key2.getKey();
                String oldKey = "+ "  + key2.getKey();
                resultMap.put(oldKey, mapFile1.get(key2.getKey()));
                resultMap.put(newKey, key2.getValue());
            }
        }

        List<String> toSort = new ArrayList<>();
        for (String key : resultMap.keySet()) {
            toSort.add(key);
        }
        toSort.sort((key1, key2) -> key1.substring(2).compareTo(key2.substring(2)));
        StringJoiner joiner = new StringJoiner("\n", "{\n", "\n}");
        for (String key : toSort) {
            String s = key + ": " + resultMap.get(key);
            joiner.add(s);
        }
        return joiner.toString();
    }
}
