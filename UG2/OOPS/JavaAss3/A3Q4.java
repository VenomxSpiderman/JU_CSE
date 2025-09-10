import java.util.*;

class ProductOfScores {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        int[] scores = new int[n];

        System.out.print("Enter scores: ");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        sc.close();

        long[] result = new long[n];
        long left = 1;

        for (int i = 0; i < n; i++) {
            result[i] = left;
            left *= scores[i];
        }

        long right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= scores[i];
        }

        System.out.println("\nProducts:");
        for (long num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}