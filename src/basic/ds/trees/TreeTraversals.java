package basic.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dreddy on 12/16/2016.
 */
public class TreeTraversals {

    public static void inorderTraversal(BinaryTree root) {
        if (root == null) return;
        if (root.leftChild != null) inorderTraversal(root.leftChild);
        System.out.print(root.data + " ");
        if (root.rightChild != null) inorderTraversal(root.rightChild);
    }

    public static void preorderTraversal(BinaryTree root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        if (root.leftChild != null) preorderTraversal(root.leftChild);
        if (root.rightChild != null) preorderTraversal(root.rightChild);
    }

    public static void postorderTraversal(BinaryTree root) {
        if (root == null) return;
        if (root.leftChild != null) postorderTraversal(root.leftChild);
        if (root.rightChild != null) postorderTraversal(root.rightChild);
        System.out.print(root.data + " ");
    }

    public static <T> void levelOrderTraversal(BinaryTree<T> root) {

        if (root == null) return;
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree<T> element = queue.poll();
            System.out.print(element.data + " ");
            if (element.leftChild != null)
                queue.add(element.leftChild);
            if (element.rightChild != null)
                queue.add(element.rightChild);
        }

    }

    public static void main(String[] args) {

        BinaryTree<Integer> root = new BinaryTree<>(0);
        root.leftChild = new BinaryTree<>(1);
        root.rightChild = new BinaryTree<>(2);
        root.leftChild.leftChild = new BinaryTree<>(3);
        root.leftChild.rightChild = new BinaryTree<>(4);
        root.rightChild.leftChild = new BinaryTree<>(5);
        root.rightChild.rightChild = new BinaryTree<>(6);
        System.out.println("Inorder Traversal");
        inorderTraversal(root);
        System.out.printf("\nPreorder Traversal\n");
        preorderTraversal(root);
        System.out.printf("\nPostOrder Traversal\n");
        postorderTraversal(root);
        System.out.printf("\nLevel Order Traversal\n");
        levelOrderTraversal(root);
    }
}
