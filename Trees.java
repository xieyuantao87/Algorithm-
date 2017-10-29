/*
 * Depth First Traversals:
*(a) Inorder (Left, Root, Right) : 4 2 5 1 3
*(b) Preorder (Root, Left, Right) : 1 2 4 5 3
*(c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Yuantao Xie
 */
public class Trees {

    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
     /*
    Given a binary tree, return the inorder traversal of its nodes' values.
    */
    public List<Integer> inorder(TreeNode root) {
    List<Integer> list = new ArrayList<>();
   
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
        while(cur!=null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }
    return list;
    }
    
    public List<Integer>  preorder(TreeNode node) {
         
        if (node == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        // Create an empty stack and push root to it
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(node);
 
        
        while (nodeStack.empty() == false) {
            TreeNode mynode = nodeStack.peek();
            list.add(mynode.val);
            nodeStack.pop();
 
            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
        return list;
    }
    
    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
 
        if(root==null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
 
        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left==null && temp.right==null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            }else {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }
 
                if(temp.left!=null) {
                     stack.push(temp.left);
                     temp.left = null;
                 }
            }
        }
 
        return res;
    }
}
