import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    protected final int customerId;
    protected String name;
    protected long phoneNumber;
    protected double currentLoanAmount;
    private static final double CREDIT_LIMIT = 10000;

    public Customer(int customerId, String name, long phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentLoanAmount = 0;
    }

    public void updateDetails(String newName, long newPhone) {
        this.name = newName;
        this.phoneNumber = newPhone;
        System.out.println("Details updated successfully.");
    }

    public boolean requestLoan(double amount) {
        if (currentLoanAmount + amount <= CREDIT_LIMIT) {
            currentLoanAmount += amount;
            return true;
        }
        return false;
    }

    public double getAvailableLoanAmount() {
        return CREDIT_LIMIT - currentLoanAmount;
    }

    public double getCurrentLoanAmount() {
        return currentLoanAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void displayCustomerDetails() {
        System.out.println("\nCustomer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Current Loan: " + currentLoanAmount);
        System.out.println("Available Loan Limit: " + getAvailableLoanAmount());
    }

    @Override
    public String toString() {
        return "Customer: " + name;
    }
}

class PrivilegedCustomer extends Customer {
    private static final double PRIVILEGED_CREDIT_LIMIT = 20000;

    public PrivilegedCustomer(int customerId, String name, long phoneNumber) {
        super(customerId, name, phoneNumber);
    }

    @Override
    public boolean requestLoan(double amount) {
        if (getCurrentLoanAmount() + amount <= PRIVILEGED_CREDIT_LIMIT) {
            currentLoanAmount += amount;
            return true;
        }
        return false;
    }

    @Override
    public void displayCustomerDetails() {
        System.out.println("\nCustomer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Current Loan: " + currentLoanAmount);
        System.out.println("Available Loan Limit: " + (PRIVILEGED_CREDIT_LIMIT - currentLoanAmount));
    }
}

public class Main {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int customerCounter = 1; 
    public static void addAccount() {
        System.out.println("Enter customer name: ");
        String name = scanner.next(); 
        
        System.out.println("Enter phone number: ");
        long phone = scanner.nextLong();

        System.out.println("Select Account Type: 1. Normal Customer 2. Privileged Customer");
        int choice = scanner.nextInt();

        if (choice == 1) {
            customers.add(new Customer(customerCounter++, name, phone));
            System.out.println("Normal account created successfully.");
            System.out.print("Your customer Id is: ");
            System.out.println(customerCounter - 1);
        } else if (choice == 2) {
            customers.add(new PrivilegedCustomer(customerCounter++, name, phone));
            System.out.println("Privileged account created successfully.");
            System.out.print("Your customer Id is: ");
            System.out.println(customerCounter - 1);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void takeLoan() {
        System.out.println("Enter Customer ID: ");
        int id = scanner.nextInt();
        Customer customer = findCustomerById(id);
    
        if (customer != null) {
            System.out.println("Enter loan amount: ");
            double amount = scanner.nextDouble();
    
            if (customer instanceof PrivilegedCustomer) {
                PrivilegedCustomer privilegedCustomer = (PrivilegedCustomer) customer;
                if (privilegedCustomer.requestLoan(amount)) {
                    System.out.println("Loan granted successfully to Privileged Customer.");
                } else {
                    System.out.println("Loan request denied due to credit limit.");
                }
            } else {
                if (customer.requestLoan(amount)) {
                    System.out.println("Loan granted successfully to Normal Customer.");
                } else {
                    System.out.println("Loan request denied due to credit limit.");
                }
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static void viewAccountDetails() {
        System.out.println("Enter Customer ID: ");
        int id = scanner.nextInt();
        Customer customer = findCustomerById(id);

        if (customer != null) {
            customer.displayCustomerDetails();
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static void changeAccountDetails() {
        System.out.println("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Customer customer = findCustomerById(id);

        if (customer != null) {
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new phone number: ");
            long newPhone = scanner.nextLong();
            customer.updateDetails(newName, newPhone);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static Customer findCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Take Loan");
            System.out.println("3. View Account Details");
            System.out.println("4. Change Account Details");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: addAccount(); break;
                case 2: takeLoan(); break;
                case 3: viewAccountDetails(); break;
                case 4: changeAccountDetails(); break;
                case 5: System.exit(0);
                break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
