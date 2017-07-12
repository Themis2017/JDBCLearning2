package demo;

/**
 * Created by 10195 on 2017/7/12.
 */
public class Test {
    String s1 = "3";
    String s2 = "3";
    public static void main(String [] args){
        Test t = new Test();
        System.out.println(t.s1==t.s2);
        System.out.println(t.s1.equals(t.s2));

    }
}
