import java.util.Scanner;

public class q5 {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        show((short)1);
        show(1.0);
        sc.close();
    }

    static void show(int i) {
        // The method show(int) in the type q5 is not applicable for the arguments(double)
        //This is the error shown when both calls are made without the overloaded function declaration
        System.out.println(i);
    }
    static void show(double i){
        System.out.println(i);
    }
}
