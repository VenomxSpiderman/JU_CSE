import java.util.*;

class SweetDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sweets : ");
        int n = sc.nextInt();
        System.out.print("Enter varieties of types : ");
        int k = sc.nextInt();
        
        List<Integer> sweets = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            sweets.add(rand.nextInt(k) + 1); 
        }
        
        Set<Integer> set = new HashSet<>(sweets);
        int x = Math.min(set.size(), n / 2);
        
        System.out.println("\nMaximum different types Soham can have (x): " + x);
        System.out.print("Enter number of combinations you want to display: ");
        int y=sc.nextInt();
        List<Integer> typesList = new ArrayList<>(set);

        int max=typesList.size();

        if(y>max){
            System.err.println("Not possible");
            sc.close();
            System.exit(0);
        }
        System.out.println("Some possible combinations:");
        
        for (int i = 0; i < y; i++) {
            List<Integer> combination = new ArrayList<>();
            combination.add(typesList.get(i));
            for (int j = 1; j < x && j < typesList.size(); j++) {
                if (i != j) combination.add(typesList.get(j));
            }
            System.out.println("Combination " + (i+1) + ": " + combination);
        }
        sc.close();

    }
}