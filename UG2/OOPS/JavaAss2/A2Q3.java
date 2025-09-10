import java.util.*;
class BinaryTree{
   public static class Node {
    String data;
    Node left;
    Node right;
    Node(String data) {
        this.data = data;
        left = right = null;
     }
    }
    Node root;
    BinaryTree() {
        root = null;
    }
    Node buildTree(String inputs[], int i){
      if(i < inputs.length){
          if(inputs[i].equals("null")) 
            return null;
          Node node = new Node(inputs[i]);
          node.left = buildTree(inputs, 2*i+1);
          node.right = buildTree(inputs, 2*i+2);
          return node;
      }
      return null;
    }
    void build(String inputs[]){
        this.root = buildTree(inputs, 0);
    }
    void printPath(Node node,ArrayList<String> array) 
    {
        if(node==null)
          return;
        if (node.left == null && node.right == null)
        {
            array.add(node.data);
            for(int i=0; i<array.size(); i++)
                System.out.print(array.get(i) + " ");
            System.out.println();
            array.remove(array.size()-1);
            return;
        }
        array.add(node.data);
        printPath(node.left,array);
        printPath(node.right,array);
        array.remove(array.size()-1);
    }
    void path(){
        ArrayList<String> array = new ArrayList<String>();
        printPath(this.root,array);
        System.out.println();
    }
}
public class A2Q3 {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        String inputs[]=new String[n];
        for(int i=0; i<n; i++){
            inputs[i] = sc.next();
        }
        tree.build(inputs);
        tree.path();
        sc.close();
    }
}
