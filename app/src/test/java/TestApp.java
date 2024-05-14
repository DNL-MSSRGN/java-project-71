
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import hexlet.code.Differ;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestApp {
    private static final String PATH1 = "src/test/resources/file1.json";
    private static final String PATH2 = "src/test/resources/file2.json";
    private static final String PATH3 = "src/test/resources/file1.yml";
    private static final String PATH4 = "src/test/resources/file2.yml";
    private static final String PATH5 = "src/test/resources/stylish.txt";

    private static final String PATH6 = "src/test/resources/plain";

    private static final String PATH7 = "src/test/resources/Json.txt";
    private static final String FORMAT1 = "stylish";
    private static final String FORMAT2 = "plain";
    private static final String FORMAT3 = "json";


    @Test
    void testStylishJson() throws Exception {
        var expected = Files.readString(Path.of(PATH5));
        String actual = Differ.generate(PATH1, PATH2, FORMAT1);
        assertEquals(expected, actual);
    }

    @Test
    void testStylishYaml() throws Exception {
        var expected = Files.readString(Path.of(PATH5));
        String actual = Differ.generate(PATH3, PATH4, FORMAT1);
        assertEquals(expected, actual);
    }

    @Test
    void testPlainJson() throws Exception {
        var expected = Files.readString(Path.of(PATH6));
        String actual = Differ.generate(PATH1, PATH2, FORMAT2);
        assertEquals(expected, actual);
    }

    @Test
    void testPlainYaml() throws Exception {
        var expected = Files.readString(Path.of(PATH6));
        String actual = Differ.generate(PATH3, PATH4, FORMAT2);
        assertEquals(expected, actual);
    }

    @Test
    void testJson() throws Exception {
        var expected = Files.readString(Path.of(PATH7));
        String actual = Differ.generate(PATH1, PATH2, FORMAT3);
        assertEquals(expected, actual);
    }

    @Test
    void testJsonYaml() throws Exception {
        var expected = Files.readString(Path.of(PATH7));
        String actual = Differ.generate(PATH3, PATH4, FORMAT3);
        assertEquals(expected, actual);
    }
}
