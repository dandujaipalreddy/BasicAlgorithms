package basic.ds.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreddy on 12/16/2016.
 */
public class Heap<T extends Comparable> {

    //heap is a complete binary Tree
    //Max Heap contains Maximum element at its root when compared to its childs
    public List<T> heap = null;

    public Heap() {
        heap = new ArrayList<T>();
    }

    public static void main(String[] args) {
        Heap<Integer> a = new Heap();
        int n = 10;
        for (int i = 0; i < n; i++) {
            int number = i;//new Random().nextInt(1000);
            System.out.print(number + " ");
            a.addToHeap(number);
        }
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(a.heap.get(i) + " ");
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(a.removeMax() + " ");
    }

    public int parent(int i) {
        if (i == 0) return 0;
        return (int) Math.floor((i - 1) / 2);
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    /*
        adds element at the end of the tree and heapifies
        complexity: 0(logN)
    * */
    public void addToHeap(T data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    public void heapifyUp(int index) {
        if (index > 0) {
            T ele = heap.get(index);
            int parentIndex = parent(index);
            T parent = heap.get(parentIndex);
            if (ele.compareTo(parent) > 0) {
                heap.remove(index);
                heap.add(index, parent);
                heap.remove(parentIndex);
                heap.add(parentIndex, ele);
            }
            heapifyUp(parentIndex);
        }
    }

    public T getMax() {
        return heap.get(0);
    }

    public T removeMax() {
        T ele = heap.remove(0);
        if (heap.size() == 0)
            return ele;
        T lastElement = heap.remove(heap.size() - 1);
        heap.add(0, lastElement);
        heapifyDown(0);
        return ele;
    }

    private void heapifyDown(int index) {

        T elemet = heap.get(index);
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        if (index < heap.size() && leftIndex < heap.size()) {
            T leftChild = heap.get(leftIndex);
            T rightChild = null;
            if (rightIndex < heap.size()) {
                rightChild = heap.get(rightIndex);
            }
            if (elemet.compareTo(leftChild) < 0 && (rightChild == null || leftChild.compareTo(rightChild) > 0)) {
                heap.remove(index);
                heap.add(index, leftChild);
                heap.remove(leftIndex);
                heap.add(leftIndex, elemet);
                heapifyDown(leftIndex);
            } else if (rightChild != null && elemet.compareTo(rightChild) < 0) {
                heap.remove(index);
                heap.add(index, rightChild);
                heap.remove(rightIndex);
                heap.add(rightIndex, elemet);
                heapifyDown(rightIndex);
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < heap.size(); i++)
            System.out.print(heap.get(i) + " ");
        System.out.println();
    }

}