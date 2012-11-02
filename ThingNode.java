
/**
 * Write a description of class ThingNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThingNode extends DecisionTreeNode {
    public ThingNode(String thing) {
        super( );
        super.setValue(thing);
    }
    
    public String getThing() {
        return super.getValue();
    
    }
    
    public String toString() {
        return super.toString();
    }
    
}
