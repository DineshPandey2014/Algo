package HashMap;

/**
 * Created by dpandey on 9/1/17.
 */
public class HashMap<K, V> {
    Object [] elements;

    public HashMap() {
        elements = new Object[15];
    }

    public void put(K key, V value) {
    /*
     * 1. Hash It.
     * 2. Get an index.
     * 3. Put it into array.
     */
        int hashCode = key.hashCode();
        System.out.println("---hashCode--forKey--> "+key+ "hashCode--> "+hashCode);
        int index = getHashMapIndex(key);
        System.out.println("---index-> "+index + "For key" + key);

        Entry<K,V> entry = new Entry(hashCode, key, value);
        if(elements[index] == null) {
            elements[index] = entry;
        } else {
         Entry<K, V> existingEntry = ( Entry<K, V>) elements[index];
            while(existingEntry.getNext() != null) {
                existingEntry = existingEntry.getNext();
            }
            existingEntry.setNext(entry);

        }
    }

    // Get the value.
    public V get(K key) {
        int hashCode = key.hashCode();
        int index = getHashMapIndex(key);

        if(elements[index] != null) {
            Entry<K,V> node = (Entry<K,V>) elements[index];
            Entry<K,V> nodeNext = node.getNext();
            while(node != null) {
                if(hashCode == node.getHashCode() && key.equals(node.getKey())) {
                    return node.getValue();
                }
                node = nodeNext;
                nodeNext = nodeNext.getNext();
            }


        } return null;
    }

    private int getHashMapIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % elements.length);
    }
}
