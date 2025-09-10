import java.util.ArrayList;
import java.util.Scanner;
public class q3i {
    static boolean is(int i)
    {
        int s=(int)Math.sqrt(i);
        return (s*s)==i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array length");
        int n=sc.nextInt();
        ArrayList<Integer> s = new ArrayList<>();
        
        for(int i=1;i<=n;i++)
        {
            if(is(i))
            s.add(i);
        }
        int skip=1;
        n=s.size();
        while (skip <= n) {
            
            ArrayList<Integer> temp=new ArrayList<>();
            for (int i = 0; i < n; i += skip)
                temp.add(s.get(i));
            
            
            System.out.println(temp.toString());
            s.clear();
            s.addAll(temp);
            n=s.size();
            skip++;
        }
        sc.close();
    }
}
