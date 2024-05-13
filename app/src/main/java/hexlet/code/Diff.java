package hexlet.code;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static hexlet.code.Parser.parser;

public class Diff {
    public static Map<String, Object> diff(String pathToFile1, String pathToFile2) throws IOException {
        Map<String, Object> mapFile1 = parser(pathToFile1);
        Map<String, Object> mapFile2 = parser(pathToFile2);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        for (var key : mapFile1.entrySet()) {
            if (!mapFile2.containsKey(key.getKey())) {
                String newKey = "rem." + key.getKey();
                resultMap.put(newKey, key.getValue());
            }
            if (mapFile2.containsKey(key.getKey())
                    && Objects.equals(mapFile1.get(key.getKey()), mapFile2.get(key.getKey()))) {
                String newKey = "sam."  + key.getKey();
                resultMap.put(newKey, key.getValue());
            }
        }
        for (var key2 : mapFile2.entrySet()) {
            if (!mapFile1.containsKey(key2.getKey())) {
                String newKey = "add." + key2.getKey();
                resultMap.put(newKey, key2.getValue());
            }
            if (mapFile1.containsKey(key2.getKey())
                    && !Objects.equals(mapFile1.get(key2.getKey()), mapFile2.get(key2.getKey()))) {

                String oldKey = "reO."  + key2.getKey();
                String newKey = "upN."  + key2.getKey();
                resultMap.put(oldKey, mapFile1.get(key2.getKey()));
                resultMap.put(newKey, key2.getValue());
            }
        }
        return resultMap;
    }
}
