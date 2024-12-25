import org.w3c.dom.Text;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringAnalyser stringAnalyser = new StringAnalyser();
        //System.out.println(stringAnalyser.getCommonWords());

        TextReader textReader = new TextReader();
        /*System.out.println(stringAnalyser.filterText(textReader.getTextOne()));
        System.out.println(stringAnalyser.filterText(textReader.getTextTwo()));*/

        Counter counter = new Counter();
        counter.countFrequency(textReader.getTextOne());
        counter.countFrequency(textReader.getTextTwo());
    }
}