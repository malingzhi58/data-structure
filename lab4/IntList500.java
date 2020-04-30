package lab4;

public class IntList500 {
    //    public class IntList5000 {
    private IntList500 rest;
    private int primitive;
    private Integer reference;
    public static String slogan;

    public IntList500(IntList500 r, int p, Integer r1, String s) {
        rest = r;
        primitive = p;
        reference = r1;
        slogan = s;
    }

    public static void disenturbulate(IntList500 p) {
        p.primitive = 5000;
        p.reference = new Integer(1000);
        System.out.println(p);
        p = new IntList500(null, 5, 10, "relax");
        System.out.println(p);
        System.out.println(p.primitive);
    }

    public void indoctrinate(int b) {
        b = 0;
        this.rest.primitive = b;
    }

    public void integrate(Integer v) {
        this.reference = v;
        v = new Integer(10);
    }

    public static void main(String[] args) {
        IntList500 x = new IntList500(null, 100, new Integer(7), "live");
        IntList500 y = new IntList500(x, 9, x.reference, "eat");
//        p = new IntList500(x, 9, x.reference, "eat");
        System.out.println(y.primitive);
        System.out.println(y.reference);
        IntList500.disenturbulate(y);
        System.out.println(y.primitive);
        System.out.println(y.reference);
        y.indoctrinate(100);
        System.out.println(x.primitive);
        x.integrate(new Integer(200));
        System.out.println(x.reference);
        System.out.println(IntList500.slogan);

    }

}
