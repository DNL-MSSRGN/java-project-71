package hexlet.code.formatters;

import hexlet.code.Diff;
import java.util.List;
import java.util.stream.Collectors;
import static hexlet.code.Compairse.ADDED;
import static hexlet.code.Compairse.REMOVED;
import static hexlet.code.Compairse.SAME;
import static hexlet.code.Compairse.UPDATED;


public final class Stylish {

    public static String buildStylish(List<Diff> items) {

        String output = items.stream()
                .map(Stylish::getLine)
                .collect(Collectors.joining("\n"));

        return "{\n" + output + "\n}";
    }

    private static String getLine(Diff obj) {
        String diff = obj.getChange();
        String key = obj.getKey();

        switch (diff) {
            case ADDED -> {
                return "  + " + key + ": " + obj.getValue();
            }
            case REMOVED -> {
                return "  - " + key + ": " + obj.getValue();
            }
            case SAME -> {
                return "    " + key + ": " + obj.getValue();
            }
            case UPDATED -> {
                return "  - " + key + ": " + obj.getValueOld() + "\n"
                        + "  + " + key + ": " + obj.getValueNew();
            }
            default -> throw new RuntimeException();
        }
    }
}
