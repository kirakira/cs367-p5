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
        Collections.sort(entries, new Comparator<SimpleHashMap.Entry<String, Integer>>() {
            public int compare(SimpleHashMap.Entry<String, Integer> a,
                SimpleHashMap.Entry<String, Integer> b) {
                int t = a.getValue().compareTo(b.getValue());
                if (t != 0)
                    return -t;
                return a.getKey().compareTo(b.getKey());
            }
        });

        int c = 0;
        for (SimpleHashMap.Entry<String, Integer> e: entries) {
            ++c;
            if (c > 11)
                break;
            System.out.println(e.getKey());
        }
    }
}
