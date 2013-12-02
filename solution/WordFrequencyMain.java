import java.io.*;
import java.util.*;

public class WordFrequencyMain {
    public static final void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        SimpleHashMap<String, Integer> map = new SimpleHashMap<String, Integer>();
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word: words) {
                Integer i = map.get(word);
                if (i != null)
                    map.put(word, i + 1);
                else
                    map.put(word, 1);
            }
        }
        br.close();

        List<SimpleHashMap.Entry<String, Integer>> entries = map.entries();
        ArrayList<SimpleHashMap.Entry<String, Integer>> sorted =
            new ArrayList<SimpleHashMap.Entry<String, Integer>>();
        for (SimpleHashMap.Entry<String, Integer> e: entries) {
                int pos = 0;
                while (pos < sorted.size() &&
                        (sorted.get(pos).getValue() > e.getValue() ||
                         (sorted.get(pos).getValue() == e.getValue() &&
                         sorted.get(pos).getKey().compareTo(e.getKey()) < 0)))
                    ++pos;
                sorted.add(pos, e);
                if (sorted.size() > 11)
                    sorted.remove(11);
            }

        for (SimpleHashMap.Entry<String, Integer> e: sorted)
            System.out.println(e.getKey());
    }
}
