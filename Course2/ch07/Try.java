package Course2.ch07;

public class Try {
//    public static void main(String[] args) {
//        Try newTry = new Try();
//        int one = 1/2;
//        System.out.println(one);
//        Object b = newTry.Ex();
//        newTry.Ex.staticEx;
//        b.staticEx;
//
//        System.out.println(staticEx);
//    }
//    public static void Ex(){
//        int staticEx = 1;
//    }
//    public static void executeEx(){
//        Ex().staticEx =12;
//        Trystatic = 2;
//    }
    static int Trystatic = 1;

    public static void main(String[] args) {
        int[] one = {1,2,3,4};
        int[] two = one;
        two[1] = 10;

        System.out.println(one[1]);

    }
}
