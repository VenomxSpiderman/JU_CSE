import java.util.*;
class PizzaOrder {
    String size;
    List<String> toppings;
 
 
    public PizzaOrder(String size, List<String> toppings) {
        this.size = size;
        this.toppings = toppings;
    }
 
 
    @Override
    public String toString() {
        return "Pizza size: " + size + ", Toppings: " + String.join(", ", toppings);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify the size of the pizza.");
            return;
        }
 
 
        String size = args[0];
        List<String> toppings = new ArrayList<>();
 
 
        for (int i = 1; i < args.length; i++) {
            toppings.add(args[i]);
        }
 
 
        PizzaOrder order = new PizzaOrder(size, toppings);
        System.out.println(order);
    }
 }
 