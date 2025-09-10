import java.util.Scanner;
public class A3Q5 {
    private static int sharedVariable;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Enter the initial value of shared variable: ");
            sharedVariable = scanner.nextInt();
            System.out.print("Enter a number to increment: ");
            int incrementValue = scanner.nextInt();
            System.out.println("Initial value of shared variable: " + sharedVariable);

            Thread incrementThread1 = new Thread(new IncrementTask(incrementValue));
            Thread incrementThread2 = new Thread(new IncrementTask(incrementValue));
            Thread decrementThread1 = new Thread(new DecrementTask());
            Thread decrementThread2 = new Thread(new DecrementTask());

            incrementThread1.start();
            incrementThread2.start();
            decrementThread1.start();
            decrementThread2.start();

            try {
                incrementThread1.join();
                incrementThread2.join();
                decrementThread1.join();
                decrementThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final value of shared variable: " + sharedVariable);

            System.out.print("Do you want to repeat? (y/n): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
    }

    static class IncrementTask implements Runnable {
        private final int incrementValue;

        public IncrementTask(int incrementValue) {
            this.incrementValue = incrementValue;
        }

        @Override
        public void run() {
            synchronized (lock) {
                sharedVariable += incrementValue;
                System.out.println("Incremented by " + incrementValue + ", current value: " + sharedVariable);
            }
        }
    }

    static class DecrementTask implements Runnable {
        private static final int DECREMENT_VALUE = 5;

        @Override
        public void run() {
            synchronized (lock) {
                sharedVariable -= DECREMENT_VALUE;
                System.out.println("Decremented by " + DECREMENT_VALUE + ", current value: " + sharedVariable);
            }
        }
    }
}