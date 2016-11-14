package basic.ds.ll;

public class SingleLinkedList<T> implements IMyList<T> {

    private Node<T> head = null;
    private Node<T> currentPos = null;

    public SingleLinkedList(T data) {
        head = new Node<>();
        head.data = data;
        head.next = null;
        currentPos = head;
    }

    public SingleLinkedList() {
        head = new Node<>();
        currentPos = head;
    }

    @Override
    public boolean add(T element) {
        // TODO Auto-generated method stub
        Node<T> newNode = new Node<>();
        newNode.next = null;
        newNode.data = element;
        currentPos.next = newNode;
        currentPos = newNode;
        return true;
    }

    @Override
    public boolean remove(T element) {
        // TODO Auto-generated method stub
        // find the element and remove it
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
