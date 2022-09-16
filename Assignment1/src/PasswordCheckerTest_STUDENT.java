
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Kevin Gomes
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String>passwords;
	String password1,password2;
	

	@Before
	public void setUp() throws Exception {
		String[] p = {"he1loWorld!","1.)Rust>Cp+>C>Java","1DidThisTheDayItWasDue!","acdcxyz77"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));	
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("12adb"));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException l) {
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e) {
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
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("acdcxyz77"));
			assertTrue("Did not throw NoUpperAlphaException",true);
		}
		catch(NoUpperAlphaException u) {
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		catch(Exception e) {
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
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ABCS&890"));
			assertTrue("Did not throw NoLowerAlphaException",true);
		}
		catch(NoLowerAlphaException l) {
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e) {
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
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("weak8"));
			assertTrue("Did not throw NoLowerAlphaException",true);
		}
		catch(WeakPasswordException w) {
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("AaBbCc777!"));
			assertTrue("Did not throw InvalidSequenceException",true);
		}
		catch(InvalidSequenceException u) {
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ABCdefg!"));
			assertTrue("Did not throw NoDigitException",true);
		}
		catch(NoDigitException u) {
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("NarutoUltimateNinjaStorm4!"));
			assertTrue("Password did not throw an Exception",true);
		}
		catch(Exception u) {
			assertTrue("Password threw an exception",false);
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
		Scanner scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "acdcxyz77");
		String nextResults = scan.nextLine();
		assertTrue(nextResults.contains("upper"));
		
		
	}
	
}
