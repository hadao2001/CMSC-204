/**
 * @author Ha Dao CMSC 204 
 * Throws exception if the password is less than six characters long.
 */

package PasswordChecker;
public class LengthException extends Exception {  
    /**
     * This no-arg constructor defines the exception message for length.
     */
    public LengthException() {
        super("The password must be at least 6 characters long");
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public LengthException(String message) {
		super(message);
	}

}