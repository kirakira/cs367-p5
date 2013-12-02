import java.io.*;
import java.util.*;

public class WordFrequencyMain {
    public static final void main(String[] args) throws FileNotFoundException, IOException {
        // TODO add your variables

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word: words) {
                // TODO update your map accordingly
            }
        }
        br.close();

        // TODO process and output the top 11 most frequent word
    }
}
