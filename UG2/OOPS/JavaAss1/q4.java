import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        q1();
        q2();
    }
    static void q1(){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.skip("\n");
        String t=s;
        System.out.println(t.equals(s));
        System.out.println(t==s);
        sc.close();
    }
    static void q2(){
        String s="Hello";
        String t = new String("Hello");
        //if we do t=t.intern() then last output will be true
        
        System.out.println(t.equals(s));
        System.out.println(t == s);
        //this gives false due to the concept of string pool
    }
}
