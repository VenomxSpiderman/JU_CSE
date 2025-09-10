import java.util.*;

public class q3 {
    static class TreeNode {
        String val;
        TreeNode left, right;

        TreeNode(String val) {
            this.val = val;
            left = right = null;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            traverse(root, new StringBuilder(), paths);
        }
        return paths;
    }

    private static void traverse(TreeNode node, StringBuilder path, List<String> paths) {
        int length = path.length();
        if (length != 0) {
            path.append("->");
        }
        path.append(node.val);

        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            if (node.left != null) {
                traverse(node.left, path, paths);
            }
            if (node.right != null) {
                traverse(node.right, path, paths);
            }
        }
        path.setLength(length); // Backtrack
    }

    static TreeNode build(String[] inputs, int index) {
        if (index >= inputs.length || inputs[index].equals("0")) {
            return null;
        }
        TreeNode node = new TreeNode(inputs[index]);
        node.left = build(inputs, 2 * index + 1);
        node.right = build(inputs, 2 * index + 2);
        return node;
    }

    public static void main(String[] args) {
        String[] inputs = { "10", "20", "80", "0", "30", "0", "90", "0", "0", "40", "50", "0", "90" };
        TreeNode root = build(inputs, 0);
        System.out.println("Root-to-leaf paths: ");
        List<String> res = binaryTreePaths(root);
        for (String st : res) {
            System.out.println(st);
        }
    }
}