package Course2.ch05;

public class Map<KeyType, ValueType>   {
    public Map() {
        items = new QuadraticProbingHashTable <Entry <KeyType, ValueType>>();
    }

    public void put(KeyType key, ValueType val) {
        Entry <KeyType, ValueType> e = new Entry <KeyType, ValueType>(key, val);
        items.insert(e);
    }

    public ValueType get(KeyType key) {
        ValueType v = (ValueType) new Object();
        Entry <KeyType, ValueType> e = new Entry <KeyType, ValueType>(key, v);
        e = items.find(e);
        return e.val;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void makeEmpty() {
        items.makeEmpty();
    }

    private QuadraticProbingHashTable <Entry <KeyType, ValueType>> items;

    private static class Entry<KeyType, ValueType> {
        Entry(KeyType k, ValueType v) {
            key = k;
            val = v;
        }

        public int hashCode() {
            return key.hashCode();
        }//public boolean equals( Entry<KeyType, ValueType> rhs )

        public boolean equals(Object rhs) {
            return rhs instanceof Entry && key.equals(((Entry <KeyType, ValueType>) rhs).key);
        }
        private KeyType key;
        private ValueType val;
    }


}

