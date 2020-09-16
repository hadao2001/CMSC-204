/**
 * @author Ha Dao
 * Throws exception if the initial and re-typing passwords don't match.
 */
package PasswordChecker;

public class UnmatchedException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for unmatched.
     */
    public UnmatchedException() {
        super("The passwords do not match");
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public UnmatchedException (String message) {
		super(message);
	}
}