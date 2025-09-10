import java.util.Scanner;

public class q3 {
    
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array length");
        int n = sc.nextInt();
        
        int skip = 1, mult = 2;
        
        while(true){
        for(int i=1;i<=n;i+=skip){
            System.out.print(i+" ");
        }
        System.out.println();
        skip *= mult;
        
        mult += 2;
        
        if(skip>=n)
        break;
    }
        sc.close();
    }
}
