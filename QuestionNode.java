
/**
 * Write a description of class QuestionNode here.
 * 
 * @author (your name) changed from windows 8
 * @version (a version number or a date)
 */
public class QuestionNode extends DecisionTreeNode {
    String question;

    public QuestionNode(String question, DecisionTreeNode noAnswer, DecisionTreeNode yesAnswer) {
        super( question, noAnswer, yesAnswer );
        
    }
    
    public String getQuestion() {
        return super.getString();
    
    }
    
    public String toString() {
        return null;
    
    }
}
    
 

