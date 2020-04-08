import java.util.Objects;

/*
    initialize Alist
    method: resize, addlast, getlast, get, size, removelast

 */
public class AList<Item> {
    private Item[] items;
    public int size;

    public AList(){
        items = (Item[])new Object[100];
        size = 0;
    }
    private void resize(int capacity){
        Item[] a= (Item[])new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
    public void addLast(Item x){
        if(size ==items.length){
            resize(size +1);
        }
        items[size] = x;
        size +=1;
    }
    public Item getLast(){
        return items[size-1];
    }
    public Item get(int i){
        return items[i];
    }
    public int size(){
        return size;
    }
    public void removeLast(){
        Item x = getLast();
        items[size - 1] = null;
        size = size - 1;
//        return x;
    }

    public static void main(String[] args) {
        AList<Integer> a = new AList<Integer>();
        a.addLast(100);
        int b= a.size();
//        System.out.println(b);
        a.addLast(200);
//        Integer c = a.removeLast();
        a.removeLast();
        b = a.getLast();
        System.out.println(b);
    }

}
