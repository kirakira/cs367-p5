/**
 * This class implements a generic map based on hash tables that uses chaining
 * as its collision resolution.
 *
 * A map is a data structure that creats a key-value mapping. Keys are
 * unique in the map. That is, there cannot be more than one value associated
 * with a same key. However different keys can map to a same value.
 *
 * The SimpleHashMap class takes two generic parameters, <tt>K</tt> and
 * <tt>V</tt>, standing for the types of keys and values respectively. Items
 * are stored in a hash table. Hash values are computed from the
 * <tt>hashCode()</tt> method of the <tt>K</tt> type objects.
 *
 * The chains for each bucket are implemented using Java's LinkedList. When
 * a hashtable is created, its initial table size and maximum load factor is
 * set to <tt>11</tt> and <tt>0.75</tt>. The hash table can hold arbitrarily
 * many key-value pairs and resizes itself itself whenever it reaches its
 * maximum load factor.
 *
 * Null values are not allowed in this map. You can assume that
 * <tt>equals()</tt> and <tt>hashCode()</tt> on <tt>K</tt> are well defined.
 * That is, if for two non-<tt>null</tt> keys <tt>k1</tt> and <tt>k2</tt>,
 * if <tt>k1.equals(k2)</tt>, then <tt>k1.hashCode() == k2.hashCode()</tt>.
 * Do not assume in the other direction.
 */
public class SimpleHashMap<K, V> {
    // TODO You may add private fields here


    /**
     * Constructs an empty hash map with initial capacity <tt>11</tt> and
     * maximum load factor <tt>0.75</tt>.
     **/
    public HashTable() {
        // TODO
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or <tt>null</tt>
     * if this map contains no mapping for the key
     */
    public V get(Object key) {
        // TODO
    }

    /**
     * Associates the specified value with the specified key in this map. If
     * the map previously contained a mapping for the key, the old value is
     * replaced.
     *
     * If the load factor of the hash table after the insertion would exceed
     * the maximum load factor <tt>0.75</tt>, then the resizing mechanism is
     * triggered. The size of the table should grow at least by a constant
     * factor in order to ensure the amortized constant complexity, but you
     * are free to decide the exact value of the new table size (e.g. whether
     * to use a prime or not). After that, and all of the mappings are rehashed
     * to the new table.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     * <tt>null</tt> if there was no mapping for <tt>key</tt>.
     */
    public V put(K key, V value) {
        // TODO
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
     * if there was no mapping for <tt>key</tt>.
     */
    public V remove(Object key) {
        // TODO
    }
}
