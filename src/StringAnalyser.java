import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnalyser {
    private List<String> commonWords;
    private TextReader textReader;
    public StringAnalyser() {
        textReader = new TextReader();
        try {
            // read all lines into a list <-- have to read it into a path as it is directly in src
            String content = Files.readString(Paths.get(getClass().getClassLoader().getResource("commonWords.txt").toURI()));
            commonWords = Arrays.asList(content.split("\\s+")); // splits on white space

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> getCommonWords() {
        return commonWords;
    }

    public List<String> filterText(List<String> text) {
        List<String> modifiedText = new ArrayList<>();

        for (String word : text) {
            boolean containsCommon = false;
            for (String commonWord : commonWords) {
                if (word.equals(commonWord)) {
                    containsCommon = true;
                    break; // exit the loop to prevent further checks (since alr found that equals)
                }
            }
                if (!containsCommon) {
                    modifiedText.add(word);
                }
        }
        return modifiedText;
    }

    public List<String> practiceFiltering(List<String> text) {
        text.removeIf(commonWords::contains);
        return text;
    }




}
