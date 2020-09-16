package PasswordChecker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Ha Dao
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwords;
	String password1, password2;
	  
	@Before
	public void setUp() throws Exception {
		String[] passwordStrings = {"123344Tu&", "LoveYou67", "dinn4r#me", "comtam91", "Coffee*75",
		        "BUNCHAngon", "noverBemN67", "ASDFGHJ", "phoSotvang%1", "dongon", "blackpink",
		        "LikeIttt^1", "BanhBao%"};
		    passwords = new ArrayList<String>();
		    passwords.addAll(Arrays.asList(passwordStrings)); // puts strings into the ArrayList
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("ComTam1&2"));
			PasswordCheckerUtility.isValidPassword("ct12&");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test	
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("456789bB%"));
			PasswordCheckerUtility.isValidPassword("456789b%");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("456789bB%"));
			PasswordCheckerUtility.isValidPassword("456789B%");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("4567bbBB@"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("4567bbB@");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("456789bbBB@"));
			PasswordCheckerUtility.isValidPassword("456789bbb@");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
        try {
        	assertEquals(true, PasswordCheckerUtility.isValidPassword("Dinner0Rt@"));
            PasswordCheckerUtility.isValidPassword("DinnerGud@");
            assertTrue("NoDigitException isn't thrown", false);
        } catch (NoDigitException e) {
            assertTrue("NoDigitException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception thrown", false);
        }
    }
	
	
	@Test
	  public void testIsValidPasswordNoSpecialCharacter() {
	    try {
	      assertEquals(true, PasswordCheckerUtility.isValidPassword("Morning4U$"));
	      PasswordCheckerUtility.isValidPassword("Mooorning4U");
	      assertTrue("Did not throw a NoSpecialCharacterException", false);
	    } catch (NoSpecialCharacterException e) {
	      assertTrue("Successfully threw a NoSpecialCharacterException", true);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	      assertTrue("Threw some other exception besides a NoSpecialCharacterException", false);
	    }
	  }
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
		      assertEquals(true, PasswordCheckerUtility.isValidPassword("Comtamcha-1"));
		      assertEquals(true, PasswordCheckerUtility.isValidPassword("BunCHAngon#2"));
		      assertEquals(true, PasswordCheckerUtility.isValidPassword("PhoRatth0^"));
		      assertEquals(true, PasswordCheckerUtility.isValidPassword("HYMymfgk9&"));
		    } catch (Exception e) {
		      System.out.println(e.getMessage());
		      assertTrue("Threw some incorrect exception", false);
		    }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
	    results = PasswordCheckerUtility.getInvalidPasswords(passwords);

	    Scanner scan = new Scanner(results.get(0)); //
	    assertEquals(scan.next(), "dinn4r#me");
	    String nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("special"));

	    scan = new Scanner(results.get(1)); //
	    assertEquals(scan.next(), "pho75ngon");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("uppercase"));

	    scan = new Scanner(results.get(2)); //
	    assertEquals(scan.next(), "BunChaNgon");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("digit"));

	    scan = new Scanner(results.get(3)); //
	    assertEquals(scan.next(), "ASDFGHL");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("lowercase"));

	    scan = new Scanner(results.get(4)); // a
	    assertEquals(scan.next(), "c888t");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("long"));

	    scan = new Scanner(results.get(5)); // a
	    assertEquals(scan.next(), "AAAbcd56@");
	    nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("same"));
	  }
	
	
}