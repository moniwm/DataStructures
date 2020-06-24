package LinkedList;

public class NodeLL<T extends Comparable<T>> {
    private T value;
    private NodeLL<T> next;

    public NodeLL(T value) {
        this.value = value;
        this.next = null;
    }

    public NodeLL(T value, NodeLL<T> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node: " + value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeLL<T> getNext() {
        return next;
    }

    public void setNext(NodeLL<T> next) {
        this.next = next;
    }
}