import java.util.*;

class TreeNode {
    String name;
    TreeNode left, right;
    
    TreeNode(String name) {
        this.name = name;
    }
}

public class A3Q3 {
    private Map<Integer, List<String>> depthMap = new HashMap<>();
    
    public TreeNode buildTree(String[] preorder, String[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(String[] preorder, int preStart, int preEnd, String[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i].equals(root.name)) {
                inIndex = i;
                break;
            }
        }
        
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + (inIndex - inStart), inorder, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + (inIndex - inStart) + 1, preEnd, inorder, inIndex + 1, inEnd);
        
        return root;
    }
    
    public void findCousins(TreeNode root) {
        traverseTree(root, 0);
        
        System.out.println("Cousins in each generation:");
        for (Map.Entry<Integer, List<String>> entry : depthMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("Generation " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    
    private void traverseTree(TreeNode node, int depth) {
        if (node == null) return;
        
        depthMap.putIfAbsent(depth, new ArrayList<>());
        depthMap.get(depth).add(node.name);
        
        traverseTree(node.left, depth + 1);
        traverseTree(node.right, depth + 1);
    }
    
    public static void main(String[] args) {
        String[] preorder = {"GrandFather", "Father", "Mother", "Me", "Cousin4", "Cousin12", "Cousin28", "Cousin29", "Cousin13", "Cousin30", "Cousin31", "Cousin5", "Cousin14", "Cousin15", "Aunt1", "Cousin1", "Cousin6", "Cousin16", "Cousin17", "Cousin7", "Cousin18", "Cousin19", "Cousin2", "Cousin8", "Cousin20", "Cousin21", "Cousin9", "Cousin22", "Cousin23", "Uncle1", "Aunt2", "Cousin3", "Cousin10", "Cousin24", "Cousin25", "Cousin11", "Cousin26", "Cousin27"};

        String[] inorder = {"Cousin28", "Cousin12", "Cousin29", "Cousin4", "Cousin30", "Cousin13", "Cousin31", "Me", "Cousin14", "Cousin5", "Cousin15", "Mother", "Father", "Cousin16", "Cousin6", "Cousin17", "Cousin18", "Cousin7", "Cousin19", "Cousin1", "Aunt1", "Cousin20", "Cousin8", "Cousin21", "Cousin22", "Cousin9", "Cousin23", "Cousin2", "GrandFather", "Cousin24", "Cousin10", "Cousin25", "Cousin26", "Cousin11", "Cousin27", "Cousin3", "Aunt2", "Uncle1"};

        A3Q3 tree = new A3Q3();
        TreeNode root = tree.buildTree(preorder, inorder);
        tree.findCousins(root);
    }
}