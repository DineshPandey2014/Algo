package HashMap;

/**
 * https://leetcode.com/problems/design-hashmap/submissions/
 *
 *  Design a HashMap without using any built-in hash table libraries.

 To be specific, your design should include these functions:

 put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

 All keys and values will be in the range of [0, 1000000].
 The number of operations will be in the range of [1, 10000].
 Please do not use the built-in HashMap library.

 Algorithm :
 1. Array Implementation
 *  To store the map data in key and value pair
 *  Used linked list approach to avaoid the collisons
 */
public class DesignHashMap {

  private static final int SIZE = 16;
  private Entry table[] = new Entry[SIZE];

  class Entry {
    String key;
    String value;
    Entry next;

    Entry(String key, String value){
      this.key = key;
      this.value = value;
    }
  }


  /*
   * Returns the entry mapped to key in the HashMap.
   */
  public Entry get(String k) {
    int hash = k.hashCode()%SIZE;

    // Get the object from Entry Array at index of hash
    Entry e = table[hash];

    // Bucket is identified by hashCode and traversed the bucket
    // till element is found
    while(e!=null) {
      if(e.key.equals(k)) {
        return e;
      }
      e = e.next;
    }
    return null;
  }

  public void put (String k, String v) {
    int hash = k.hashCode()%SIZE;
    Entry e = table[hash];

    if(e != null) {
         // If we will insert duplicate key-value pair.
         // Old value will be replaced by new one.
          if(e.key.equals(k)) {
            e.value = k; // Just replace the value
          } else {
            // Collison insert new elements at the end of list
            // in the same bucket
          }



    } else {
      Entry entryInBucket = new Entry(k,v);
      table[hash] = entryInBucket;
    }
  }
}

