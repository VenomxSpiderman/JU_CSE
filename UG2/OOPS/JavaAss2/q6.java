import java.util.*;
public class q6 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //System.out.println("Enter an integer:");
        int n2=in.nextInt();
        System.out.println("Int to Object");
        Integer n1=n2;
        //System.out.println(n1);
        System.out.println("To prove that this is an object we are appling some methods specific to Integer wrapper class:");
        System.out.println("Method intValue():\t" + n1.intValue());
        
        //  n1=n1.parseInt("20");
        
        System.out.println(n1);
        System.out.println("Object to int");
        int n3=n1;
        System.out.println(n3);
        System.out.println("Int to string");
        String s=Integer.toString(n2);
        System.out.println(s);
        System.out.println("String to int");
        int n4=Integer.parseInt(s);
        System.out.println(n4);
        System.out.println("Object to string");
        String s2=n1.toString();
        System.out.println(s2);
        in.close();
    }


    
}
