/**
 *
 */
package basic.ds.trees;

import java.util.Collection;
import java.util.Random;

/**
 * @author dreddy
 */
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    private Node<T> rootOfBST;

    public BinarySearchTree() {
        rootOfBST = null;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Random r = new Random(100);
        for (int i = 0; i < 20; i++) {
            bst.add(r.nextInt(300));
        }

        bst.printBST();
        System.out.println(bst.getKthSmallest(5));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.jaipal.trees.ITree#add(java.lang.Object)
     */
    @Override
    public boolean add(T value) {
        rootOfBST = add(rootOfBST, value);
        return rootOfBST == null;
    }

    public int size(Node<T> root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);

    }

    private Node<T> add(Node<T> root, T value) {

        if (root == null) return new Node<T>(value);

        if (root.data.compareTo(value) > 0)
            root.left = add(root.left, value);

        else if (root.data.compareTo(value) < 0) root.right = add(root.right, value);

        root.n = 1 + size(root.left) + size(root.right);
        return root;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.jaipal.trees.ITree#remove(java.lang.Object)
     */
    @Override
    public T remove(T value) {

        return null;
    }

    public void printBST() {

        Node<T> temp = rootOfBST;
        inorder(temp);
    }

    private void inorder(Node<T> temp) {
        if (temp.left != null) inorder(temp.left);
        System.out.print(temp.data + " ");
        if (temp.right != null) inorder(temp.right);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.jaipal.trees.ITree#clear()
     */
    @Override
    public void clear() {

    }

    /*
     * (non-Javadoc)
     *
     * @see com.jaipal.trees.ITree#contains(java.lang.Object)
     */
    @Override
    public boolean contains(T value) {

        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.jaipal.trees.ITree#size()
     */
    @Override
    public int size() {

        return rootOfBST.n;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.jaipal.trees.ITree#validate()
     */
    @Override
    public boolean validate() {

        return false;
    }

    public T getMinimum() {

        return getMinimum(rootOfBST);
    }

    private T getMinimum(Node<T> root) {
        if (root.left == null) return root.data;
        return getMinimum(root.left);

    }

    public T getMaximum() {

        return getMaximum(rootOfBST);
    }

    private T getMaximum(Node<T> root) {
        if (root.right == null) return root.data;
        return getMaximum(root.right);

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T getKthSmallest(int k) {

        if (k <= 0) throw new IllegalArgumentException();
        return select(rootOfBST, k - 1).data;
    }

    private Node<T> select(Node<T> x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);
        else
            return x;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.jaipal.trees.ITree#toCollection()
     */
    @Override
    public Collection<T> toCollection() {

        return null;
    }

    protected static class Node<T extends Comparable<T>> {

        private T data;
        private Node<T> left;
        private Node<T> right;
        private int n;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
        }

    }
}
