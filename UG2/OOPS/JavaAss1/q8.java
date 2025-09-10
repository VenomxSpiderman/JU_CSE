import java.util.Scanner;

class Instructor {
    private String name;
    private String phoneNumber;
 
 
    public Instructor(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
 
 
    public String getName() {
        return name;
    }
 
 
    public void setName(String name) {
        this.name = name;
    }
 
 
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
 
    @Override
    public String toString() {
        return "Instructor{name='" + name + "', phoneNumber='" + phoneNumber + "'}";
    }
 }
 
 
 class Textbook {
    private String title;
    private String author;
    private String publisher;
 
 
    public Textbook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
 
 
    public String getTitle() {
        return title;
    }
 
 
    public void setTitle(String title) {
        this.title = title;
    }
 
 
    public String getAuthor() {
        return author;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
 
 
    public String getPublisher() {
        return publisher;
    }

} 
class Course{
    String name;
    Instructor i;
    Textbook t;
    public Course(String name, Instructor i1, Textbook t1) {
        this.name = name;
        i=new Instructor(i1.getName(),i1.getPhoneNumber());
        t=new Textbook(t1.getTitle(), t1.getAuthor(), t1.getPublisher());
    }
    @Override
    public String toString(){
        return "Course{name=" + name+"}";
    }
}
public class q8{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Instructor instructor = null;
        Textbook textbook = null;
        Course course = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Set Instructor Information");
            System.out.println("2. View Instructor Information");
            System.out.println("3. Set Textbook Information");
            System.out.println("4. View Textbook Information");
            System.out.println("5. Set Course Information");
            System.out.println("6. View Course Information");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Instructor Name: ");
                    String instructorName = scanner.nextLine();

                    System.out.print("Enter Instructor Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    
                    instructor = new Instructor(instructorName, phoneNumber);
                    System.out.println("Instructor information set successfully.");
                    break;

                case 2:
                    if (instructor != null) {
                        System.out.println(instructor);
                    } else {
                        System.out.println("Instructor information not set.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Textbook Title: ");
                    String title = scanner.nextLine();
                    
                    System.out.print("Enter Textbook Author: ");
                    String author = scanner.nextLine();
                    
                    System.out.print("Enter Textbook Publisher: ");
                    String publisher = scanner.nextLine();
                    
                    textbook = new Textbook(title, author, publisher);
                    System.out.println("Textbook information set successfully.");
                    break;

                case 4:
                    if (textbook != null) {
                        System.out.println(textbook);
                    } else {
                        System.out.println("Textbook information not set.");
                    }
                    break;

                case 5:
                    if (instructor == null || textbook == null) {
                        System.out.println("Cannot set course information. Ensure Instructor and Textbook are set.");
                    } else {
                        System.out.print("Enter Course Name: ");
                        String courseName = scanner.nextLine();
                        course = new Course(courseName, instructor, textbook);
                        System.out.println("Course information set successfully.");
                    }
                    break;

                case 6:
                    if (course != null) {
                        System.out.println(course);
                        System.out.println(course.i);
                        System.out.println(course.t);

                    } else {
                        System.out.println("Course information not set.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    
    }
}