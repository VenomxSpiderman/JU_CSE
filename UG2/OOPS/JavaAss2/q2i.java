import java.util.*;

public class q2i {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    private static void sum(Node head,Node cycle) {
        
        Node temp = head;
        Stack<Integer> st=new Stack<>();
        while (temp != cycle) {
           //System.out.println(temp.data);
            if (temp.data % 2 == 0)
                st.add(temp.data);
            temp = temp.next;
        }
        if(cycle.data%2==0)
            st.add(cycle.data);
        
        temp = cycle.next;

        while (temp != cycle) {
            //System.out.println(temp.data);
            if (temp.data % 2 == 0)
                st.add(temp.data);
            temp = temp.next;
        }
        
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
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

        sum(head,temp1);
        sc.close();
    }
}

