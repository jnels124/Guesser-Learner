import java.io.*;
/**
 * Write a description of class GuesserLearner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuesserLearner {
    
    public static void main (String [] args) { // check for valid node before createing new tree
        MyTree guesserGame;
        DecisionTreeNode root = deserializeTree(MyTree.knowledgeBase);
        if (root == null) {
            guesserGame = new MyTree();
            serializeTree(MyTree.knowledgeBase, guesserGame);
        } else {
            guesserGame = new MyTree(root);
            serializeTree(MyTree.knowledgeBase, guesserGame);
          }
          
        
        /*while(true) {
            if(UserInterface.playAgain()) {
                guesserGame = new MyTree(deserializeTree(MyTree.knowledgeBase));
                serializeTree(MyTree.knowledgeBase, guesserGame);
            } else {
                System.exit(0);
              }
        }*/
    }
    
    public static void serializeTree(File outFile, MyTree newTree) {
        try {
            OutputStream output = new FileOutputStream(outFile);
            OutputStream fileBuffer = new BufferedOutputStream(output);
            ObjectOutput objectOutput = new ObjectOutputStream(fileBuffer);
            try {
                objectOutput.writeObject( newTree.root);
            } finally {  // change this
                objectOutput.close();
            }
        } catch (IOException e ) {
            System.out.println("Unable to serialize object");
            e.printStackTrace(); 
          }
    }
    
    /**
     * Reads the data tree from the file.
     * 
     * @param inFile is the file to read from.
     * 
     * @return the tree root.
     */
    public static DecisionTreeNode deserializeTree(File inputFile) {
        try {
            ObjectInput input = new ObjectInputStream( 
                new BufferedInputStream( new FileInputStream( inputFile ) ) 
            );
            try {
                @SuppressWarnings( "unchecked" )
                DecisionTreeNode root = (DecisionTreeNode)input.readObject();
                return root;
            }
            finally {
                input.close();
            }
        }
    
        catch (java.io.FileNotFoundException e) { }
        catch (ClassNotFoundException ex) {
            System.err.println("Unsuccessful deserialization: Class not found. " + ex);
        }
        catch (IOException ex) {
            System.err.println("Unsuccessful deserialization: " + ex);
        }
        return null;
    }

}
