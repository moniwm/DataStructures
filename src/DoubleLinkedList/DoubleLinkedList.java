package DoubleLinkedList;

import LinkedList.LinkedList;

public class DoubleLinkedList<T extends Comparable<T>> {
    private NodeDLL<T> first = null;
    private NodeDLL<T> last = null;
    private int size = 0;

    public void addFirst(T value) {
        NodeDLL<T> newElement = new NodeDLL<T>(value, this.first, null);
        newElement.setPrevious(this.first);
        this.first = newElement;
        if (this.last == null) {
            this.last = this.first;
        }
        size++;
    }

    public int getSize(){
        return this.size;
    }


    public void addLast(T value) {
        if (this.first == null) {
            this.first = this.last = new NodeDLL<T>(value);
            return;
        }
        NodeDLL<T> newElement = new NodeDLL<>(value);
        this.last.setNext(newElement);
        newElement.setPrevious(this.last);
        this.last = newElement;
        size++;
    }

    /**
     * Looks for an item in the list
     * @param e element to find
     * @return zero-based index of the item or -1 if not found
     */
    public int find(T e) {
        NodeDLL<T> temp = this.first;
        int index = 0;
        while (temp != null) {
            if (temp.getValue().compareTo(e) == 0) {
                return index;
            }
            index++;
            temp = temp.getNext();
        }
        return -1;
    }

    public T getValue(int index){

        NodeDLL<T> current = this.first;
        int reference = 0;

        while(current != null){

            if(reference == index){

                return current.getValue();
            }

            else if(index>getSize()-1){
                System.out.println("Index out of limits");
                return null;
            }

            else{
                reference++;
                current = current.getNext();
            }

        }
        return null;

    }

    public void modifyValue(T e, int index){

        NodeDLL<T> current = this.first;
        int reference = 0;

        while(current != null){

            if(reference == index){

                current.setValue(e);
                return;
            }

            else if(index>getSize()-1){
                System.out.println("Index out of limits");
                return;
            }

            else{
                reference++;
                current = current.getNext();
            }

        }
        return;

    }

    public T insertElement(T e, int index){

        NodeDLL<T> current = this.first;
        NodeDLL<T> previous = this.first;
        int reference = 0;

        while(current != null){

            if(reference == index){

                if (current == this.first){
                    addFirst(e);
                }

                else{

                    NodeDLL<T> newElement = new NodeDLL<T>(e,current,previous);
                    previous.setNext(newElement);
                    current.setPrevious(newElement);
                }
                size++;
                return current.getValue();
            }

            else if(index>getSize()-1){
                System.out.println("Index out of limits");
                return null;
            }

            else{
                previous = current;
                current = current.getNext();
                reference++;
            }


        }
        return null;


    }

    public NodeDLL<T> deleteElement(T e){

        NodeDLL<T> current = this.first;
        NodeDLL<T> previous = this.first;

        while(current != null){

            if(current.getValue().compareTo(e) == 0){
                if (current == this.first){
                    this.first = this.first.getNext();
                    this.first.setPrevious(null);
                }

                else if(current.getNext()==null){
                    current.getPrevious().setNext(null);
                }
                else{
                    previous.setNext(current.getNext());
                    previous.getNext().setPrevious(previous);
                }
                size--;
                return current;
            }

            else{
                previous = current;
                current = current.getNext();
            }


        }
        return null;
    }

    public NodeDLL<T> deleteFirst(){
        if(this.first!=null){
            NodeDLL<T> temp = this.first;
            this.first = this.first.getNext();
            this.first.setPrevious(null);
            size--;
            return temp;

        }
        else{
            return null;
        }
    }

    public NodeDLL<T> deleteLast(){
        if(this.last != null){
            NodeDLL<T> temp = this.last;
            this.last = this.last.getPrevious();
            this.last.setNext(null);
            size--;
            return temp;
        }
        else{
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.first == null) {
            return "List of: <empty>";
        }
        StringBuilder stringBuilder = new StringBuilder("List of: ");
        NodeDLL<T> temp = this.first;
        while (temp != null) {
            stringBuilder.append(temp.getValue().toString());
            stringBuilder.append(" ");
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }

    public NodeDLL<T> getLast(){
        return this.last;
    }

}
