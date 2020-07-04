package Trees;

/**
 * This class implements a binary search tree
 *
 * @author moniwaterhouse
 * @since 06/20/2020
 *
 * @param <T> is used to implement generics
 *
 */

public class AVLTree<T extends Comparable<T>> {

    private Node<T> root;

    public AVLTree(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
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
            node.height = 1 + max(height(node.left),
                    height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
            int balance = getBalance(node);

            // If this node becomes unbalanced, then there
            // are 4 cases Left Left Case
            if (balance > 1 && element.compareTo(node.left.element) < 0)
                return rightRotate(node);

            // Right Right Case
            if (balance < -1 && element.compareTo(node.right.element) > 0)
                return leftRotate(node);

            // Left Right Case
            if (balance > 1 && element.compareTo(node.left.element) > 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Left Case
            if (balance < -1 && element.compareTo(node.right.element) < 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
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

        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return node;
    }

    int height(Node<T> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node<T> leftRotate(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node<T> N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

}
