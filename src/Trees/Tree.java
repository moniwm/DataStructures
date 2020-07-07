package Trees;

/**
 * Abstract class used to create the shared methods of the Binary Search Tree, AVL Tree and Splay Tree
 * this way, duplicated code will be avoided.
 *
 * @param <T>
 */

public abstract class Tree<T extends Comparable<T>> {

    private Node<T> root;

    private boolean isBST;
    private boolean isAVL;
    private boolean isSplay;


    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * This method is used to set the type of tree in the child classes constructor
     * @param type the type of AVLTree
     */
    protected void setTypeTree(String type){
        if(!isSplay & !isAVL & !isBST){
            if(type.equals("splay")){
                this.isSplay = true;
            }
            else if(type.equals("avl")){
                this.isAVL = true;
            }
            else{
                this.isBST = true;
            }
        }
    }

    /**
     * Method that can be accessed by a user to search an element in the tree
     * @param element the element to be searched
     * @return a recursive call to the private contain method
     */

    public boolean contains(T element){
        return this.contains(element, this.root);
    }

    /**
     * This method works as an auxiliary for the public contains method
     * and in this way the root can remain unaccessed by the user.
     *
     * @param element is the elements to be found
     * @param node the node that the element is being compare to
     * @return a recursive call to the private contain method
     */

    private boolean contains(T element, Node<T> node) {
        if(node == null){
            return false;
        }
        else {
            int compareResult = element.compareTo(node.element);

            if(compareResult < 0){
                return contains(element, node.left);
            }
            else if(compareResult > 0){
                return contains(element, node.right);
            }
            else{
                return true;
            }
        }
    }

    /**
     * Finds the minimum value of the tree
     * @return a recursive call to the private findMin method
     */

    public Node<T> findMin(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return this.findMin(this.root);
        }
    }

    /**
     * This method works as an auxiliary to look for the minimum value of the tree
     *
     * @param node is the node that is currently analized
     * @return the node that contains the minimum value
     */

    private Node<T> findMin(Node<T> node) {
        if(node == null){
            return null;
        }
        else if(node.left == null){
            return node;
        }
        else{
            return findMin(node.left);
        }
    }

    /**
     * Finds the maximum value of the tree
     * @return a recursive call to the findMax method
     */

    public Node<T> findMax(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return this.findMax(this.root);
        }
    }

    /**
     * This method works as an auxiliary to look for the minimum value of the tree
     * @param node is the node that is currently analized
     * @return the node that contains the maximum value
     */

    private Node<T> findMax(Node<T> node) {
        if(node == null){
            return null;
        }
        else if(node.right == null){
            return node;
        }
        else{
            return findMax(node.right);
        }
    }

    /**
     * This method insert a new element as a leaf
     * @param element the value of the element that is wanted to be added in the tree
     */

    public void insert(T element){
        this.root = this.insert(element, this.root);
    }

    /**
     * This is the auxiliary method that has access to the tree root and
     * inserts an element as a leaf
     *
     * @param element the element that is going to be inserted
     * @param node the current node that is being compared
     * @return the node where the element is inserted
     */

    private Node<T> insert(T element, Node<T> node) {
        if(node == null){
            return new Node<T>(element);
        }

        int compareResult = element.compareTo(node.element);

        if(compareResult < 0){
            node.left = this.insert(element, node.left);
        }
        else if( compareResult > 0){
            node.right = this.insert(element, node.right);
        }

        return node;
    }

    /**
     * Removes an element from the tree
     * @param element the element that is going to be erased
     */

    public void remove(T element){
        this.root = this.remove(element, this.root);
    }

    /**
     * The auxiliary to the remove method that has access to the tree root and
     *
     * @param element the element that is going to be removed
     * @param node the node that is being compared
     * @return the node in which the element was eliminated
     */

    private Node<T> remove(T element, Node<T> node) {

        if (node == null){
            return null;
        }

        int compareResult = element.compareTo(node.element);

        if(compareResult < 0){
            node.left = remove(element, node.left);
        }

        else if(compareResult > 0){
            node.right = remove(element,node.right);
        }

        else if(node.left != null && node.right != null){
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        }

        else{
            node = node.left!=null ? node.left : node.right;
        }

        return node;
    }

    public void getRootValue(){
        System.out.println(this.root.element);
    }



}
