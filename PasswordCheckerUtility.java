package PasswordChecker;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Check passwords validity and strength.
	@author Ha Dao
 */
public class PasswordCheckerUtility {
	public PasswordCheckerUtility() {}
	
	   /**
		* Return true if valid password. Throws exceptions for invalid passwords. 
		* Valid if password is greater than or equal to 6 characters, has at least one digit, has at least on upper-case alphabetic character, has at least on lower-case alphabetic character, and has no more than two of the same character in a row.
		* @param passwordString string to be checked for validity
		* @return true if valid password (follow all rules from above), false if an invalid password
		* @throws LengthException thrown if length is less than 6 characters
		* @throws NoDigitException thrown if not digit
		* @throws NoUpperAlphaException thrown if no uppercase alphabetic
		* @throws NoLowerAlphaExecption thrown if no lowercase alphabetic
		* @throws InvalidSequenceExeption thrown if more than 2 of same character.
		* @throws NoSpecialSCharacterException thrown if no special character.
		*/
	public static boolean isValidPassword (String passwordString) 
			        throws LengthException,
		                   NoDigitException,
		                   NoUpperAlphaException,
		                   NoLowerAlphaException,
		                   InvalidSequenceException,
		                   NoSpecialCharacterException{
		
		
		boolean isValid = true;	
		
		 //Length check
		if (passwordString.length() < 6) {
	        throw new LengthException();
	    }

		//Digit check
	    for (int i = 0; i < passwordString.length(); i++) {
	        if (!Character.isDigit(passwordString.charAt(i))) {
	            if (i == passwordString.length() - 1) {
	                throw new NoDigitException();
	            }
	        } else {
	            break;
	        }
	    }
	 
	    //Upper case check
	    for (int i = 0; i < passwordString.length(); i++) {
	        if (!Character.isUpperCase(passwordString.charAt(i))) {
	            if (i == passwordString.length() - 1) {
	                throw new NoUpperAlphaException();
	            }
	        } else {
	            break;
	        }
	    }

	    //Lower case check
	    for (int i = 0; i < passwordString.length(); i++) {
	        if (!Character.isLowerCase(passwordString.charAt(i))) {
	            if (i == passwordString.length() - 1) {
	                throw new NoLowerAlphaException();
	            }
	        } else {
	            break;
	        }
	    }

	    //Sequence check
	    for (int i = 0; i < passwordString.length()- 2; i++) {
	    	if (passwordString.charAt(i) == passwordString.charAt(i+1) 
	                    && (passwordString.charAt(i + 1) == passwordString.charAt(i + 2))) {
	                throw new InvalidSequenceException();
	            }
	        }
	    
	
	//Special character check
	
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(passwordString);
        boolean hasSpecialChar = matcher.find();
        if (hasSpecialChar == false) {
            throw new NoSpecialCharacterException();
        }
        return true;
    }

	

	/**
	 * Return true if length of password is greater or equal to 6 but less than or equal to 9
	 * @param passwordString The passsword to be tested
	 * @return true if length of password is greater than or equal to 6 but less than or equal to 9
	 */
	
	public static boolean isWeakPassword(String passwordString) {
		return (passwordString.length() > 5 && passwordString.length() < 10) ? true : false;
	}	
	
	
	/**
     * This static method is responsible for validating passwords
     * from a password and returning invalid password with exception messages.
     * @param passwords the array list of password to be validated obtained 
     * from a file.
     * @return invalid passwords with their respective exception message.
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPassword = new ArrayList<>();

        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception ex) {
                invalidPassword.add(password + " " + ex.getMessage() + "\n");
            }
        }

        return invalidPassword;
    }

	
}
		                   


