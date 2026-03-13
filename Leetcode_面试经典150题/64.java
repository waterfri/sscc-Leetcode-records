// #64 二叉树的中序遍历
// 二叉树
// 递归遍历

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    void inorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
