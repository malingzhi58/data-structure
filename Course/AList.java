import java.lang.reflect.Array;

/**
 * Array based list.
 *
 * @author Josh Hug
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

public class AList {
    private int[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /**
     * Resizes the underlying array to the target capacity.
     */
    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void reverse() {
        for (int i = 0; i < items.length / 2; i++) {
            int j = items.length - i - 1;
            int temp = items[j];
            items[j] = items[i];
            items[i] = temp;
        }
    }

    public int[] replicate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += arr[i];
        }
        AList newList = new AList();
        newList.resize(sum);
        for (int i = 0; i < this.size - 1; i++) {
            for (int j = 0; j < this.items[i] - 1; j++) {
                newList.items[j] = this.items[i];
            }

        }
        return newList.items;
    }

    public int[] repli(int[] arr) {
        int total = 0;
        for (int item : arr) {
            total += item;
        }
        int[] result = new int[total];
        int i = 0;
        for (int item : arr) {
            for (int counter = 0; counter < item; counter++) {
                result[i] = item;
                i++;
            }
        }
        return result;
    }
    public static int[] flatt(int[][] arr){
        int[] overall = new int[100];
        int index = 0;
        for(int i = 0; i<arr.length;i++){
//            System.arraycopy(arr[i],0,overall,0,arr[i].length);
            for(int j =0; j<arr[i].length;j++){
                overall[index] = arr[i][j];
                index++;
            }
        }
        return overall;
    }
    public static int[] flatt2(int[][] arr){
        int[] overall = new int[100];
        int index = 0;
        for(int i = 0; i<arr.length;i++){
            System.arraycopy(arr[i],0,overall,0,arr[i].length);
//            for(int j =0; j<arr[i].length;j++){
//                overall[index] = arr[i][j];
//                index++;
//            }
        }
        return overall;
    }


    /**
     * Inserts X into the back of the list.
     */
    public void addLast(int x) {
        if (size == items.length) {
            resize((int) (size * 1.1));
        }

        items[size] = x;
        size = size + 1;
    }

    /**
     * Returns the item from the back of the list.
     */
    public int getLast() {
        return items[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public int get(int i) {
        return items[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public int removeLast() {
        int x = getLast();
        size = size - 1;
        return x;
    }

    public static void main(String[] args) {
        AList l = new AList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
//        l.resize(6);
//        int[] newl = l.replicate(l.items);
        int[][] arr = {{1,2},{3,4,5,6},{7,8,9}};
        int[] one=flatt(arr);
        for (int i = 0; i < 10; i++) {
            System.out.println(one[i]);
        }
    }
} 