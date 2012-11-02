import javax.swing.JOptionPane;
/**
 * Write a description of class DialogBoxes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogBoxes {
    static String userInput;
    // have no use for this method in this project but I will implement it in the future 
    public static String confirmDialog(String msg) {
    return null;
            
    }
    
    public static boolean yesNoOption(String msg, String boxTitle) {
        int n = JOptionPane.showConfirmDialog(null,  msg, boxTitle, 
                                              JOptionPane.YES_NO_OPTION);
    return n == JOptionPane.YES_OPTION;
    }               
        
    public static String InputDialog(String msg) {
    return JOptionPane.showInputDialog(msg);
    }
    
    public static void messageDialog(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void errorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
        
    }
    
}
