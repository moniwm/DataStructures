package DoubleLinkedList;

/**
 * Double linked list
 *
 * @author moniwaterhouse
 *
 * @param <T> used to implement generics
 */
public class NodeDLL<T extends Comparable<T>> {
    private T value;
    private NodeDLL<T> next;
    private NodeDLL<T> previous;

    public NodeDLL(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public NodeDLL(T value, NodeDLL<T> next, NodeDLL<T> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
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

    public NodeDLL<T> getNext() {
        return next;
    }

    public void setNext(NodeDLL<T> next) {
        this.next = next;
    }

    public NodeDLL<T> getPrevious(){
        return previous;
    }

    public void setPrevious(NodeDLL<T> previous){
        this.previous = previous;
    }

}