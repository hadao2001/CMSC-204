/**
 * @author Ha Dao
 * Throws exception if no digit is found in the password.
 */

package PasswordChecker;
public class NoDigitException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for no digit.
     */
    public NoDigitException() {
        super("The password must contain one digit");
    }
    
    /**
	 * 
	 * @param message errorMessage
	 */
	public NoDigitException(String message) {
		super(message);
	}
}