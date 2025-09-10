import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter 2 short numbers");

        System.out.println((short) (sc.nextShort() + sc.nextShort()));
        
        sc.close();
    }
}