

/**
 * This class will contain various types of dialog boxes, used to 
 * obtain and/or inform, information to and from the user. ()
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserInterface {
    public boolean openingMessage(String message) {
        return DialogBoxes.yesNoOption(message, "Welcome!");
    }
    
    public boolean makeGuess(String currentThing) {
        return DialogBoxes.yesNoOption("Is it a " + currentThing + " ?", "Guess");
    }
    
    public boolean askQuestion(String question) {
        return DialogBoxes.yesNoOption(question, "Question");
    }
    
    public boolean getQuestionRelationship(String thing) {
        return DialogBoxes.yesNoOption("What is the correct response from your question for " + 
                                       thing, "Question Relationship");
    }
    
    public static boolean playAgain() {
        return DialogBoxes.yesNoOption("Would you like to play again", "Play Again!");
    }
    public ThingNode getNewThing() {
        
        return new ThingNode(DialogBoxes.InputDialog("What were you thinking of?"));
    }
    
    public String getNewQuestion() {
        return DialogBoxes.InputDialog("Please proivde a yes no question to distinguish " +
                                        "between my guess and what you were thinking of.");
    }
    
}
