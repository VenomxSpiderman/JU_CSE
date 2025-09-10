import java.util.*;

public class q2 {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    private static int sum(Node head,Node cycle) {
        int sum = 0;
        if(cycle.data%2==0)
            sum += cycle.data;
        Node temp = head;

        while (temp != cycle) {
            if (temp.data % 2 == 0)
                sum += temp.data;
            temp = temp.next;
        }
        
        temp = cycle.next;

        while (temp != cycle) {
            if (temp.data % 2 == 0)
                sum += temp.data;
            temp = temp.next;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first value of the linked list");
        int data = sc.nextInt();
        Node head = new Node(data);
        Node temp = head, temp1 = null;
        boolean flag = true;
        while (true) {
            System.out.println("Do you want to add more nodes? (y/n)");
            char ch = sc.next().charAt(0);
            if (ch == 'n')
                break;
            System.out.println("Enter the value of the node");
            data = sc.nextInt();
            Node node = new Node(data);
            temp.next = node;
            temp = node;
            if (flag) {
                System.out.println("Do you want the current node to be the last node? (y/n)");
                char ch1 = sc.next().charAt(0);
                if (ch1 == 'y') {
                    temp1 = temp;
                    flag = false;
                }
            }
        }
        temp.next = temp1;

        System.out.println("The sum of all even numbers in the linked list is: " + sum(head,temp1));
        sc.close();
    }
}
