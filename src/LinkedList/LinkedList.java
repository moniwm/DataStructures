package LinkedList;

/**
 * Linked list
 *
 * @author moniwaterhouse
 * @since 06/24/2020
 *
 * @param <T>
 */

public class LinkedList<T extends Comparable<T>> {
    private NodeLL<T> first;
    private NodeLL<T> last;
    private int size = 0;

    public LinkedList(){
        this.first = null;
        this.last = null;
    }

    public int getSize(){
        return this.size;
    }

    public NodeLL<T> getLast(){
        return this.last;
    }

    public NodeLL<T> getFirst(){
        return this.first;
    }


    /**
     * Adds an element in the first position of the list
     * @param value element to be added
     */
    public void addFirst(T value) {
        NodeLL<T> newElement = new NodeLL<T>(value, this.first);
        this.first = newElement;
        if (this.last == null) {
            this.last = this.first;
        }
        size++;
    }

    /**
     * Adds an element at the end of the list
     * @param value element to be added
     */

    public void addLast(T value) {
        if (this.first == null) {
            this.first = this.last = new NodeLL<>(value);
            return;
        }
        NodeLL<T> newElement = new NodeLL<>(value);
        this.last.setNext(newElement);
        this.last = newElement;
        size++;
    }

    /**
     * Adds an element in a specific position
     * @param e element to be added
     * @param index the position where is going to be added
     *
     */

    public NodeLL<T> insertElement(T e, int index){

        NodeLL<T> current = this.first;
        NodeLL<T> previous = this.first;
        int reference = 0;

        while(current != null){

            if(reference == index){

                if (current == this.first){
                    addFirst(e);
                }

                else{

                    NodeLL<T> newElement = new NodeLL<T>(e,current);
                    previous.setNext(newElement);
                }
                size++;
                return current;
            }

            else if(index>getSize()-1){
                System.out.println("Index out of limits");
            }

            else{
                previous = current;
                current = current.getNext();
                reference++;
            }


        }

        return null;


    }

    /**
     *  Deletes the first element of the list
     * @return the element that was deleted
     */

    public NodeLL<T> deleteFirst(){
        if(this.first!=null){
            NodeLL<T> temp = this.first;
            this.first = this.first.getNext();
            size--;
            return temp;

        }
        else{
            return null;
        }
    }

    /**
     * Deletes the last element of the list
     * @return the element that was deleted
     */

    public NodeLL<T> deleteLast(){
        if(this.last != null){
            NodeLL<T> temp = this.getNode(this.getSize()-2);
            temp.setNext(null);
            this.last = temp;
            size--;
            return temp;
        }
        else{
            return null;
        }
    }

    /**
     * Deletes an element from the list
     * @param e the element that is going to be deleted
     * @return the element that was deleted
     */

    public NodeLL<T> deleteElement(T e){

        NodeLL<T> current = this.first;
        NodeLL<T> previous = this.first;

        while(current != null){

            if(current.getValue().compareTo(e) == 0){
                if (current == this.first){
                    this.first = this.first.getNext();
                }

                else{
                    previous.setNext(current.getNext());
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

    /**
     * Deletes an element from an specific index of the list
     * @param index the index of the position of the element that is going to be deleted
     *
     */

    public void deleteElementIndex(int index){

        NodeLL<T> previous = this.getNode(index-1);
        previous.setNext(previous.getNext().getNext());

    }



    /**
     * Looks for an item in the list
     * @param e element to find
     * @return zero-based index of the item or -1 if not found
     */

    public int find(T e) {
        NodeLL<T> temp = this.first;
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

    /**
     * Returns the node from a specific position
     * @param index the position where the node is going be grabbed
     * @return the node that was requested
     */

    public NodeLL<T> getNode(int index){

        NodeLL<T> current = this.first;
        int reference = 0;

        while(current != null){

            if(reference == index){

                return current;
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

    /**
     * Gets the value from the node of a specific position
     * @param index the position from where the value is going to be obtained
     * @return the value wanted
     */

    public T getValue(int index){
        return this.getNode(index).getValue();
    }

    /**
     * Modifies the value of an element of a specific position
     * @param e the new value of the element
     * @param index the position where the element is going to be changed
     */

    public void modifyValue(T e, int index){

        NodeLL<T> current = this.first;
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


    @Override
    public String toString() {
        if (this.first == null) {
            return "List of: <empty>";
        }
        StringBuilder stringBuilder = new StringBuilder("List of: ");
        NodeLL<T> temp = this.first;
        while (temp != null) {
            stringBuilder.append(temp.getValue().toString());
            stringBuilder.append(" ");
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }



}
