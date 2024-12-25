import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TextReader {
    private List<String> textOne;
    private List<String> textTwo;
    public TextReader() {
        try {
            // read all lines into a list <-- have to read it into a path as it is directly in src
            String content = Files.readString(Paths.get(getClass().getClassLoader().getResource("textOne.txt").toURI())).toLowerCase();
            textOne = Arrays.asList(content.split("\\s+"));

            String content1 = Files.readString(Paths.get(getClass().getClassLoader().getResource("textTwo.txt").toURI())).toLowerCase();
            textTwo = Arrays.asList(content1.split("\\s+"));

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        replaceText(textOne);
        replaceText(textTwo);
    }

    public void replaceText(List<String> text) {
        for (int i = 0; i < text.size(); i++) {
            // make sure there is no punctuation in texts, only alphabets
            String normalizedText = text.get(i).replaceAll("[^a-zA-Z]", "");
            text.set(i, normalizedText);
        }
    }

    public List<String> getTextOne() {
        return textOne;
    }

    public List<String> getTextTwo() {
        return textTwo;
    }
}
