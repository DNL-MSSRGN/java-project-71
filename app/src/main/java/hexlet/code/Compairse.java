package hexlet.code;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;

public class Compairse {
    public static final String ADDED = "added";
    public static final String REMOVED = "removed";
    public static final String SAME = "same";
    public static final String UPDATED = "updated";

    public static List<Diff> differ(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {

        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        List<Diff> results = new ArrayList<>();

        for (String k : keys) {
            Diff newEntry = addNewItem(k, mapFile1, mapFile2);
            results.add(newEntry);
        }

        return results;
    }

    private static Diff addNewItem(String key, Map<String, Object> map1, Map<String, Object> map2) {
        Object val1 = map1.get(key);
        Object val2 = map2.get(key);

        if (map1.containsKey(key) && !map2.containsKey(key)) {
            return Diff.builder()
                    .withChange(REMOVED)
                    .withKey(key)
                    .withValue(val1)
                    .build();

        } else if (!map1.containsKey(key) && map2.containsKey(key)) {
            return Diff.builder()
                    .withChange(ADDED)
                    .withKey(key)
                    .withValue(val2)
                    .build();
        } else if (Objects.equals(val1, val2)) {
            return Diff.builder()
                    .withChange(SAME)
                    .withKey(key)
                    .withValue(val1)
                    .build();
        } else {
            return Diff.builder()
                    .withChange(UPDATED)
                    .withKey(key)
                    .withValueOld(val1)
                    .withValueNew(val2)
                    .build();
        }
    }
}
