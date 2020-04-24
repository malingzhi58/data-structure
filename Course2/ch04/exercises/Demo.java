package Course2.ch04.exercises;

public class Demo {
    public static void main(String[] args) {
        Demo oneDemo = new Demo();
        oneDemo.one =1;
        oneDemo.func();
//        System.out.println();
    }
    int one;
    public  void func(){
        if(one<10){
            int oneif = 2;
        }else{
            int oneelse =3;
        }
    }
}
