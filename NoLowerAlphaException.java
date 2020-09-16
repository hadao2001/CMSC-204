/**
 * @author Ha Dao CMSC 204 
 * Throws exception if password does not contain a lowercase alphabetic charecter.
 */

package PasswordChecker;

public class NoLowerAlphaException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for no lower alpha.
     */
    public NoLowerAlphaException() {
        super("The password must contain at least \n" +"one lowercase alphabetic character");
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}