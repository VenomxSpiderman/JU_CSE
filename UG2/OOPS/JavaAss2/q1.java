import java.util.Scanner;

public class q1 {

    public static int maxArea(int[] height) {
        int left = 0; 
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

            maxWater = Math.max(maxWater, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        System.out.println("Maximum water that can be contained is " + maxArea(height) + " sq. units");
        
        sc.close();
    }
}
