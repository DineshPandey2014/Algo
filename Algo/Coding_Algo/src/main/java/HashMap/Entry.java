package HashMap;

/**
 * Created by dpandey on 9/1/17.
 */
public class Entry<K,V> {
    private K key;
    private V value;
    private long hashCode;
    private Entry<K,V> next;

    Entry(long hashCode, K key, V value) {
        this.hashCode = hashCode;
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public long getHashCode() {
        return hashCode;
    }

    public void setHashCode(long hashCode) {
        this.hashCode = hashCode;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }
}
