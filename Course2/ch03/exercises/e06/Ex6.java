package Course2.ch03.exercises.e06;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 约瑟夫斯问题:
 *
 * @author pfjia
 * @since 2017/12/7 20:16
 */
public class Ex6 {

    /**
     * 使用list模拟操作过程
     *
     * @param n 总人数
     * @param m 隔m人进行一次清除
     */
    public void foo(int n, int m) {
        int index = 0;
        List <Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        //每次外层循环清除一个玩家
        while (list.size() > 1) {
            index = (index + m) % list.size();
            int removed = list.remove(index);
            System.out.println("removed:" + removed);
        }
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
//        new Ex6().foo(5, 0);
        pass(0,5);
//        for(int i =0 ;i<10;i++)
//            System.out.println(i);
    }

    public static void pass(int m, int n) {
        int i, j, mPrime, numLeft;
        ArrayList <Integer> L = new ArrayList <Integer>();
        for (i = 1; i <= n; i++) L.add(i);
        ListIterator <Integer> iter = L.listIterator();
        Integer item = 0;
        numLeft = n;
        mPrime = m % n;
        for (i = 0; i < n; i++) {
            mPrime = m % numLeft;
            if (mPrime <= numLeft / 2) {
                if (iter.hasNext()) item = iter.next();
                for (j = 0; j < mPrime; j++) {
                    if (!iter.hasNext()) iter = L.listIterator();
                   item = iter.next();
                }
            } else {
                for (j = 0; j < numLeft - mPrime; j++) {
                    if (!iter.hasPrevious()) iter = L.listIterator(L.size());
                    item = iter.previous();
                }
            } System.out.print("Removed" + item + "");
            iter.remove();
            if (!iter.hasNext()) iter = L.listIterator();
            System.out.println();
            for (Integer x : L) System.out.print(x + "");
            System.out.println();
            numLeft--;
        } System.out.println();
    }
}
