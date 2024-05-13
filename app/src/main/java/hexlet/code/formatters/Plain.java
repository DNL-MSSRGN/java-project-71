package hexlet.code.formatters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.Diff.diff;

public class Plain {


    private static String getPlainFormattedString(Object value) {

        if (value == null) {
            return null;
        } else if (value.toString().contains("[") || value.toString().contains("{")) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }

    }

    public static String comparisonPlain(String pathToFile1, String pathToFile2) throws IOException {
        var diffs = diff(pathToFile1, pathToFile2);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        StringBuilder rezStr = new StringBuilder();
        List<String> toSort = new ArrayList<>();
        toSort.addAll(diffs.keySet());
        toSort.sort((key1, key2) -> key1.substring(4).compareTo(key2.substring(4)));
        String updated = "";

        for (var key : toSort) {
            var info = key.split("\\.");
            var status = info[0];
            if (status.equals("rem")) {
                rezStr.append("Property '" + info[1] + "' was removed" + "\n");
            } else if (status.equals("reO")) {
                updated = "Property '" + info[1] + "' was updated. From "
                        + getPlainFormattedString(diffs.get(key)) + " to ";
            } else if (status.equals(("upN"))) {
                updated += getPlainFormattedString(diffs.get(key)) + "\n";
                rezStr.append(updated);
                updated = "";

            } else if (status.equals("add")) {
                rezStr.append("Property '" + info[1] + "' was added with value: "
                        + getPlainFormattedString(diffs.get(key)) + "\n");
            }
        }

        if (rezStr.length() > 0) {
            rezStr.setLength(rezStr.length() - 1);
        }
        return rezStr.toString();
    }

}
