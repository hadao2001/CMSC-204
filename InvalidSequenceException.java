
/**
 * Throws exception if more than two of the same character are in sequence while checking the password.
 */

package PasswordChecker;
public class InvalidSequenceException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for invalid sequence.
     */
    public InvalidSequenceException() {
    	super("The password may not have more than\n "
                + "two of the same character in sequence");
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public InvalidSequenceException (String message) {
		super(message);
	}
}
