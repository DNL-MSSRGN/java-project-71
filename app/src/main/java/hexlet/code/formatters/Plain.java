package hexlet.code.formatters;

import hexlet.code.Diff;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static hexlet.code.Compairse.ADDED;
import static hexlet.code.Compairse.REMOVED;
import static hexlet.code.Compairse.SAME;
import static hexlet.code.Compairse.UPDATED;


public class Plain {
    public static String buildPlain(List<Diff> items) throws Exception {

        return items.stream()
                .filter(i -> !i.getChange().equals(SAME))
                .map(Plain::getLine)
                .collect(Collectors.joining("\n"));
    }

    private static String modifyValue(Object x) {
        if (x == null) {
            return "null";
        } else if (x instanceof List<?> || x instanceof Map<?, ?>) {
            return "[complex value]";
        } else if (x instanceof String) {
            return "'" + x + "'";
        } else {
            return x.toString();
        }
    }

    private static String getLine(Diff obj) {
        String diff = obj.getChange();
        String key = obj.getKey();

        switch (diff) {
            case ADDED -> {
                Object z = obj.getValue();
                return "Property '" + key + "' was added with value: " + modifyValue(z);
            }
            case REMOVED -> {
                return "Property '" + key + "' was removed";
            }
            case UPDATED -> {
                Object x = obj.getValueOld();
                Object y = obj.getValueNew();
                return "Property '" + key + "' was updated. From "
                        + modifyValue(x) + " to " + modifyValue(y);
            }
            default -> throw new RuntimeException();
        }
    }
}

