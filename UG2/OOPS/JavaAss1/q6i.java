import java.util.*;
class PizzaOrder1 {
    String size;
    List<String> toppings;
 
 
    public PizzaOrder1(String size, String... toppings) {
        this.size = size;
        this.toppings = Arrays.asList(toppings);
    }
 
 
    @Override
    public String toString() {
        return "Pizza size: " + size + ", Toppings: " + String.join(", ", toppings);
    }
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();
    while (T-- > 0) {
        System.out.println("Enter pizza size:");
        String size = sc.nextLine();
        System.out.println("Enter toppings separated by space:");
        String[] toppings = sc.nextLine().split(" ");
        PizzaOrder1 order = new PizzaOrder1(size, toppings);
        System.out.println(order);
    }
    sc.close();
 }

}