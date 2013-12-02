import java.util.*;

public class SimpleHashMap<K, V> {
    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V ret = value;
            this.value = value;
            return ret;
        }
    }

    private LinkedList<Entry<K, V>>[] table = create(11);
    private int size = 0;
    private double lf = 0.75;

    private int hash(Object k) {
        int ret = k.hashCode() % table.length;
        if (ret < 0)
            ret += table.length;
        return ret;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private LinkedList<Entry<K, V>>[] create(int l) {
        return new LinkedList[l];
    }

    public V get(Object key) {
        if (key == null)
            throw new NullPointerException();

        int h = hash(key);
        if (table[h] == null)
            return null;
        for (Entry<K, V> e: table[h])
            if (e.getKey().equals(key))
                return e.getValue();
        return null;
    }

    public V put(K key, V value) {
        if (key == null || value == null)
            throw new NullPointerException();

        int h = hash(key);
        if (table[h] == null)
            table[h] = new LinkedList<Entry<K, V>>();
        for (Entry<K, V> e: table[h])
            if (e.getKey().equals(key)) {
                V ret = e.getValue();
                e.setValue(value);
                return ret;
            }
        table[h].add(new Entry<K, V>(key, value));
        ++size;

        if ((double) size / (double) table.length > lf) {
            List<Entry<K, V>> old = entries();
            table = create(table.length * 2 + 1);
            size = 0;
            for (Entry<K, V> e: old)
                put(e.getKey(), e.getValue());
        }
        return null;
    }

    public V remove(Object key) {
        if (key == null)
            throw new NullPointerException();

        int h = hash(key);
        if (table[h] == null)
            return null;
        for (Iterator<Entry<K, V>> iter = table[h].iterator();
                iter.hasNext(); ) {
            Entry<K, V> cur = iter.next();
            if (cur.getKey().equals(key)) {
                V ret = cur.getValue();
                iter.remove();
                --size;
                return ret;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public List<Entry<K, V>> entries() {
        ArrayList<Entry<K, V>> ret = new ArrayList<Entry<K, V>>();
        for (LinkedList<Entry<K, V>> list: table) {
            if (list != null)
                for (Entry<K, V> e: list)
                    ret.add(e);
        }
        return ret;
    }
}
