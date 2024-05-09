
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import hexlet.code.Differ;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TestApp {
    private static final String PATH1 = "src/test/resources/file1.json";
    private static final String PATH2 = "src/test/resources/file2.json";
    private static final String PATH3 = "src/test/resources/resultDiffer.txt";

    @Test
    void testGenerate() throws Exception {
        var expected = Files.readString(Path.of(PATH3));
        String actual = Differ.generate(PATH1, PATH2);
        assertEquals(expected, actual);
    }
}
