import java.util.Random;

/**
 * This class represents the Mastermind Game Session
 * 
 * The mastermind model simply holds a correct answer
 * consisting of an ordering of four colors which
 * may include orange, yellow, red, purple, blue, green,
 * @author Lauren Olson, laols574
 *
 */
public class MastermindModel {
	//private variable(s) to store the answer

	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
	private String answer;
	
	/**
	 * this is the no args constructor for MastermindModel 
	 */
    public MastermindModel() { 
    	answer = createAnswer();
    }
    
    /**
     * This private method generates a random String of the 
     * first initials of the colors used in the Mastermind game
     * @return newAnswer - a string that holds the answer used by the Mastermind game
     */
    private String  createAnswer() {
    	String possibleColors = "roygbp";
    	String newAnswer = "";
    	Random rand = new Random();
    	for(int i = 0; i < 4; i++) {
    			int randColor = rand.nextInt(possibleColors.length());
    			newAnswer += possibleColors.charAt(randColor);
    			
    	}
    	return newAnswer;
    	
    }
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	// TODO Take answer and somehow store it as your answer. Make sure the getColorAt method 
    	// still works
    	this.answer = answer;
    }

    /**
     * 
     * @param index - the index of String to return 
     * @return Return color at position index as a char
     */
    public char getColorAt(int index) {
    	return answer.charAt(index); 
    }
    

}