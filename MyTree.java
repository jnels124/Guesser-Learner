import java.io.File;
import javax.swing.JOptionPane;
/**
 * Write a description of class MyTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyTree extends UserInterface {
    static final String GREETING = "In this game you will think of a Musician(s) " + 
                                    "and I will guess who you were thinking of.\n\n" + 
                                    "Want to play?";    
    static final File knowledgeBase = new File( "knowledge.ser" );
                
    DecisionTreeNode root;
    /**
     * Creates a brand new Tree 
     */
    public MyTree() {
        this.root = new ThingNode("Souls of Mischief");
        openingMessage(GREETING); 
        traverseData(this.root, null);
    }
    
    public MyTree(DecisionTreeNode root) {
        this.root = root;
        openingMessage(GREETING); 
        traverseData(this.root, null);
    }
    
    public DecisionTreeNode traverseData(DecisionTreeNode child, QuestionNode currentRoot) {// change this to return nothing
        if(child == null) {
            throw new NullPointerException
            ("There is no place to start traverseing data");
        } 
      
        // At the end of tree, guarnteed a thing node
        // Guess is correct else expand knowledge base
        if(child.getClass() == ThingNode.class) { 
            if(super.makeGuess(child.getValue())) { // change to get string
                return child;
            } else {
                expandKnowledgeBase((ThingNode)child, currentRoot); return null;
              }
            // Traverse tree until a ThingNode is reached
        } else if(child.getClass() == QuestionNode.class) {
            QuestionNode question = (QuestionNode)child; 
            if(super.askQuestion(question.getQuestion())) {
                return traverseData(child.getYesLink(), question);
            } else {
                return traverseData(child.getNoLink(), question);
              }   
          }
        return child;
    }
    
    public void expandKnowledgeBase(ThingNode wrongThing, QuestionNode currentRoot) {
        QuestionNode newQuestion = null;
        ThingNode correctThing = super.getNewThing();
        System.out.println( " before method " + correctThing.getValue());
        String question = super.getNewQuestion();
        if(currentRoot == null) { // Expanding knowledge base on tree with a Thing as root
            if(super.getQuestionRelationship(correctThing.getValue())) {
                System.out.println("Inside root is null");
                newQuestion = new QuestionNode(question, wrongThing, correctThing);
                this.root = newQuestion;
            } else {
                System.out.println(correctThing.getValue());
                newQuestion = new QuestionNode(question, correctThing, wrongThing);
                this.root = newQuestion;
              }
        }
        else {
            if(super.getQuestionRelationship(correctThing.getValue())) {
                newQuestion = new QuestionNode(question, wrongThing, correctThing);
                if(currentRoot.getNoLink() == wrongThing) {
                    currentRoot.setNoLink(newQuestion);                
                } else {
                    currentRoot.setYesLink(newQuestion);
                  }
                        
            } else {
                newQuestion = new QuestionNode(question, correctThing, wrongThing); 
                if(currentRoot.getNoLink() == wrongThing) {
                    currentRoot.setNoLink(newQuestion);                
                } else {
                    currentRoot.setYesLink(newQuestion);
                  }
                //currentRoot.setNoLink(newQuestion);*/
            }
            
        }
         
    }
}
