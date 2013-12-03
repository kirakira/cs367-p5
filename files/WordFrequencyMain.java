import java.io.*;
import java.util.*;

public class WordFrequencyMain {
    public static final void main(String[] args) {
        // TODO add your variables

        // TODO check if there are exactly one argument in args
 
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word: words) {
                    // TODO update your map accordingly
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO handle exception here
        } catch (IOException e) {
            // TODO handle exception here
        }

        // TODO process and output the top 11 most frequent word
    }
}
