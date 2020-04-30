package lab4;

import lab2.Intlist.IntList;

import java.util.ArrayList;

public class Mid {
    public static int[] sans(ArrayList x, int y) {
        int[] xfirst = new int[x.size()];
        int c = 0;
        for (int i = 0; i < x.size(); i += 1) {
            if ((int) x.get(i) != y) {
                xfirst[c] = (int) x.get(i);
                c = c + 1;
            }
        }
        int[] r = new int[c];
        System.arraycopy(xfirst, 0, r, 0, c);
        return r;
    }

    public static int[] sans2(ArrayList x, int y) {
        int[] xfirst = new int[x.size()];
        int c = 0;
        for (int i = 0; i < x.size(); i += 1) {
            if ((int) x.get(i) != y) {
                xfirst[c] = (int) x.get(i);
                c = c + 1;
            }
        }
//        int[] r = new int[c];
//        System.arraycopy(xfirst, 0, r, 0, c);
        return xfirst;
    }

    public static IntList ilsans(IntList x, int y) {
        if (x == null) {
            return null;
        }
        if (x.first == y) {
            return ilsans(x.rest, y);
        }
        return new IntList(x.first, ilsans(x.rest, y));
    }
    public static void  ilansdes(IntList x, int y){
        while (x.rest!=null){
            if(x.first!=y){
            x = x.rest;}else {

            }

        }

    }

    public static void main(String[] args) {
        ArrayList one = new ArrayList();
        one.add(1);
        one.add(2);
        one.add(3);
        int y = 2;
        sans(one, y);
        sans2(one, y);

    }
}
