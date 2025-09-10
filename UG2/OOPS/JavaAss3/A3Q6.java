import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int current = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                printFizz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            if (current % 5 == 0 && current % 3 != 0) {
                printBuzz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            if (current % 15 == 0) {
                printFizzBuzz.run();
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}

class FizzBuzzThreads {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(number -> System.out.print(number + " "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}