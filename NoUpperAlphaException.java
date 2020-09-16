/**
 * @author Ha Dao CMSC 204 
 * Throws exception if no uppercase alphabetic charecter is found in the password.
 */

package PasswordChecker;
public class NoUpperAlphaException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for no upper alpha.
     */
    public NoUpperAlphaException() {
        super("The password must contain at least \n" + "one uppercase alphabetic character");
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}