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
        Comparator<SimpleHashMap.Entry<String, Integer>> compare =
            new Comparator<SimpleHashMap.Entry<String, Integer>>() {
            public int compare(SimpleHashMap.Entry<String, Integer> a,
                SimpleHashMap.Entry<String, Integer> b) {
                int t = a.getValue().compareTo(b.getValue());
                if (t != 0)
                    return -t;
                return a.getKey().compareTo(b.getKey());
            }
        };

        ArrayList<SimpleHashMap.Entry<String, Integer>> sorted =
            new ArrayList<SimpleHashMap.Entry<String, Integer>>();
        for (SimpleHashMap.Entry<String, Integer> e: entries) {
                int pos = 0;
                while (pos < sorted.size() &&
                        compare.compare(sorted.get(pos), e) < 0)
                    ++pos;
                sorted.add(pos, e);
                if (sorted.size() > 11)
                    sorted.remove(11);
            }

        for (SimpleHashMap.Entry<String, Integer> e: sorted)
            System.out.println(e.getKey());
    }
}
