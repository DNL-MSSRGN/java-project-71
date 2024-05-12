
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
    private static final String PATH5 = "src/test/resources/resultDiffer.txt";

    @Test
    void testGenerateJson() throws Exception {
        var expected = Files.readString(Path.of(PATH5));
        String actual = Differ.generate(PATH1, PATH2);
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateYaml() throws Exception {
        var expected = Files.readString(Path.of(PATH5));
        String actual = Differ.generate(PATH3, PATH4);
        assertEquals(expected, actual);
    }
}
