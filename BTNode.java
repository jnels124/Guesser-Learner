
/**
 * Write a description of class BTNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BTNode<T> implements java.io.Serializable { // Bounded to ensure only extended classes are able to instantiate 
    private BTNode<T> left;
    private BTNode<T> right;
    private T value = null;
    
    /**
     * Default constructor 
     */
    public BTNode() {
        
    }
    
    public BTNode(T value) {
        this.value = value;        
    }
    
    public BTNode(T value, BTNode<T> leftChild, BTNode<T> rightChild ) {
        this.left= leftChild; /// verify this works
        this.right = rightChild;
        this.value = value;
    }
    
    public void setLeftChild(BTNode<T> left) {
        this.left = left;
    }
    
    public void setRightChild(BTNode<T> right) {
        this.right = right;
    }
    
    public BTNode<T> getLeftChild() {
        return this.left;
    }
    
    public BTNode<T> getRightChild() {
        return this.right;
    }
    
    public T getValue() {
        return this.value;
    }
    
    public void setValue(T value) {
        this.value = value;        
    }
    
    public String toString() {
        return null;
    }
}
