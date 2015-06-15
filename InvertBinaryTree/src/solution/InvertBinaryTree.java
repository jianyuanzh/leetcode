package solution;

import data.struct.TreeNode;

import java.util.Stack;

/**
 * Created by vincent on 15/6/14.
 * Invert a Binary Tree.
 */

public class InvertBinaryTree {

    static class Solution {
        private void _inverTree_notRecu(TreeNode root) {
            if (root == null)
                return;
            Stack<TreeNode> nodes = new Stack<>();
            nodes.push(root);
            TreeNode temp, temp2;
            while (!nodes.empty()) {
                temp = nodes.pop();
                temp2 = temp.left;
                temp.left = temp.right;
                temp.right = temp2;
                if (temp.left != null)
                    nodes.push(temp.left);
                if (temp.right != null)
                    nodes.push(temp.right);
            }
        }

        private void _invertTree(TreeNode root) {
            if (root == null)
                return;
            if (root.left == null && root.right == null)
                return;
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            _invertTree(root.left);
            _invertTree(root.right);
        }

        public TreeNode invertTree(TreeNode root, boolean recurisiveMode) {
            if (recurisiveMode) {
                _invertTree(root);
            } else {
                _inverTree_notRecu(root);
            }

            return root;
        }

        public TreeNode invertTree(TreeNode root) {
            _inverTree_notRecu(root);
            return root;
        }
    }


    public static boolean case01() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode rest = new Solution().invertTree(root,true);

        System.out.println(rest.val);
        System.out.println(rest.left.val + "\t" + rest.right.val);
        System.out.println(rest.left.left.val + "\t" + rest.left.right.val + "\t" + rest.right.left.val + "\t" + rest.right.right.val);

        return true;
    }

    public static void main(String[] args) {
        case01();
    }
}
