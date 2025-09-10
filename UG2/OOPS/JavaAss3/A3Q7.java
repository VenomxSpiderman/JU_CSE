import java.util.*;

class ModifiedFizzBuzz {
    public static void main(String[] args) {
        int n = 10; 
        String[] result = new String[n];

        Runnable fizzBuzzLogic = () -> {
            for (int i = 1; i <= n; i++) {
                if (i % 5 == 0 && i % 7 == 0) {
                    result[i - 1] = "fizzbuzz";
                } else if (i % 5 == 0 && i % 9 != 0) {
                    result[i - 1] = "fizz";
                } else if (i % 7 == 0 && i % 3 != 0) {
                    result[i - 1] = "buzz";
                } else {
                    result[i - 1] = "" + i;
                }
            }
        };

        fizzBuzzLogic.run();
        System.out.println(Arrays.toString(result));
    }
}