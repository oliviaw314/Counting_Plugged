import java.util.ArrayList;
import java.util.List;

public class Counter {
    public void countFrequency(List<String> text) {
        List<String> modifiedList = new ArrayList<>();
        List<Integer> frequencies = new ArrayList<>();
        for (String word : text) {
            // if word appears more than once in text
            if (modifiedList.contains(word)) {
                // have to check from modified list not text because text will always contain its own word
                int index = modifiedList.indexOf(word);
                frequencies.set(index, frequencies.get(index)+1);
            }
            else {
                modifiedList.add(word);
                frequencies.add(1);
            }
        }

       // finding word with highest frequency

        int count = 0;
        // index of top 5 words with highest frequencies
        while (count<5) {
            int largest = frequencies.get(0);
            int index = 0;
            for (int i=0; i<frequencies.size(); i++) {
                if (frequencies.get(i)>largest) {
                    // below largest variable is only used for word w/ the highest frequency as you don't need to know frequencies of other 4 words
                    largest = frequencies.get(i);
                    index = i;
                    frequencies.remove(i);
                    modifiedList.remove(i);
                    i--;
                }
            }
            count++;
            if (count==1) {
                System.out.println("The word with the highest frequency is '" + modifiedList.get(index) + "', with a frequency of " + largest + ".");
                System.out.println("The top five words with the highest frequencies are as follows:");
                System.out.println("1. "+modifiedList.get(index));
            }
            else {
                System.out.println(count+". "+modifiedList.get(index));
            }
        }

    }

}
