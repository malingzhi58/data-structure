package Course.syntax3.accessControl.syntax3.map;

public class OHRequest {
    public String description;
    public String name;
    public OHRequest next;

    public OHRequest(String description, String name, OHRequest next) {
        this.description = description;
        this.name = name;
        this.next = next;
    }

    public static void main(String[] args) {
        OHRequest s1 = new OHRequest("Failing my test for get in arrayDeque, NPE", "Pam", null);
        OHRequest s2 = new OHRequest("conceptual: what is dynamic method selection", "Michael", s1);
        OHRequest s3 = new OHRequest("git: what does checkout do.", "Jim", s2);
        OHRequest s4 = new OHRequest("help", "Dwight", s3);
        OHRequest s5 = new OHRequest("debugging get(i)", "Creed", s4);
        OHQueue q = new OHQueue(s5);
        for(OHRequest o :q){
            System.out.println(o.name);
        }
//        System.out.println();
    }

}
