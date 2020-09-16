/**
 * @author Ha Dao
 * Throws exception if no special character is found in the password.
 */
package PasswordChecker;

public class NoSpecialCharacterException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for no special character.
     */
    public NoSpecialCharacterException() {
        super("The password must contain at least \n" + "one special character ");
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public NoSpecialCharacterException (String message) {
		super(message);
	}
}
