
/**
 * Abstract class DecisionTreeNode - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class DecisionTreeNode extends BTNode <String>{

    public DecisionTreeNode() {
        super();
        
    }
    
    public DecisionTreeNode(String value, DecisionTreeNode no, DecisionTreeNode yes) {
        super(value, no, yes);
        
    }
    
    public void setNoLink(DecisionTreeNode link) {
        super.setLeftChild(link);
        
    }
    
    public void setYesLink(DecisionTreeNode link) {
        super.setRightChild(link);      
        
    }
    
    public DecisionTreeNode getNoLink() {
        return (DecisionTreeNode)super.getLeftChild();
    }
    
    public DecisionTreeNode getYesLink() {
        return (DecisionTreeNode)super.getRightChild();
    }
    
    public String getString() {
        return super.getValue();
    }
}
