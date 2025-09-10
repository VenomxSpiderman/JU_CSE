//Q2
public class Circle {

    private final double PI = 3.14; 
    private double radius;

    // Constructor to accept radius as input
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(Circle other) {
        // Create a shallow copy of circle1
        this.radius = other.radius; 
    }
    public double calculateArea() {
        return PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        System.out.println("Circle 1 Area: " + circle1.calculateArea());

        // Creating a shallow copy of circle1
        Circle circle2 = circle1; 
        System.out.println("Circle 2 Area (Shallow Copy): " + circle2.calculateArea());

        // Modifing circle1's radius
        circle1.setRadius(7); 
        System.out.println("Circle 1 Area (After modification): " + circle1.calculateArea());
        System.out.println("Circle 2 Area (Shallow Copy): " + circle2.calculateArea()); // Note the change in circle2

        // Creating a deep copy of circle1
        Circle circle3 = new Circle(circle1.getRadius()); 
        System.out.println("Circle 3 Area (Deep Copy): " + circle3.calculateArea());

        // Modifying circle1's radius again
        circle3.setRadius(9); 
        System.out.println("Circle 1 Area (After modification): " + circle1.calculateArea());
        System.out.println("Circle 3 Area (Deep Copy): " + circle3.calculateArea());
        // Remains unchanged
    }
}