package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Diff;

import java.util.List;

public final class Json {

    public static String buildJson(List<Diff> diff) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(diff);
    }
}
