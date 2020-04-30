package Course.syntax1.DIY.Map61B;

import org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * An array based implementation of the Map61B class.
 */
public class ArrayMap<K, V> implements Map61B<K, V> {
    private K[] k;
    private V[] v;
    private int size;

    public ArrayMap() {
        K[] k = (K[])new Object[100];
        V[] v = (V[])new Object[100];
        size =0;
    }

    /** Returns the index of the given key if it exists,
     *  -1 otherwise. */
    private int keyIndex(K key) {
//        for(K item :k){
//            if(item.equals(key)){
//                return
//            }
//        }
        for(int i =0;i<size-1;i++){
            if(k[i].equals(key)){
                return i;
            }
        }
        return -1;
    }


    public boolean containsKey(K key) {
        return false;
    }

    public void put(K key, V value) {
        
    }

    public V get(K key) {
        for(int i =0;i<size-1;i++){
            if(k[i].equals(key)){
                return v[i];
            }
        }
        return null;

    }

    public int size() {
        return 0;
    }

    public List<K> keys() {
        return null;
    }

    /*@Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals(expected, am.get(2));
    }*/

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
    }
}
