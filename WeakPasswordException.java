/**
 * @author Ha Dao
 * Throws exception if password's length is between 6 and 9.
 */

package PasswordChecker;

public class WeakPasswordException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for weak password.
     */
    public WeakPasswordException() {
        super("The password is OK but weak - it contains fewer than 10 characters.");     
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public WeakPasswordException (String message) {
		super(message);
	}
}