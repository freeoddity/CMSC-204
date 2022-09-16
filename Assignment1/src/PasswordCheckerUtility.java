import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Kevin Gomes
 */
public class PasswordCheckerUtility {
	
	/**
	 * Iterates through every String Password in the ArrayList<String> Passwords
	 * Calls isValidPassword on the current password. if the function call throws and exception then
	 * the exception message and password are added to a ArrayList<String> dedicated to store invalid passwords
	 * After all elements are done processing, the invalid passwords array list is returned.
	 * @param passwords
	 * @return ArrayList<String>
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 * 
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String>invalid_passwords = new ArrayList<String>();
		for (String password: passwords) {
			boolean password_is_valid = false;
			try {
				password_is_valid = isValidPassword(password);
			}
			catch(Exception e) {
				invalid_passwords.add(password + " -> " + e.getMessage());
			}
		}
		return invalid_passwords;
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Calls Numerous Passwords checker utility functions to ensure the password passed is a valid password.
	 * If it is not then an exception is thrown.
	 * 
	 * @param password
	 * @return boolean
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		// TODO Auto-generated method stub
		boolean is_valid_password = false;
		boolean is_valid_len = isValidLength(password);
		boolean contains_upper_alpha = hasUpperAlpha(password);
		boolean contains_lower_alpha = hasLowerAlpha(password);
		boolean contains_digit = hasDigit(password);
		boolean contains_special_char = hasSpecialChar(password);
		boolean same_seq = NoSameCharInSequence(password);
		if (is_valid_len && contains_digit && contains_upper_alpha && contains_lower_alpha && contains_special_char && !same_seq) {
			is_valid_password = true;
		}
		return is_valid_password;
	}
	
	/**
	 * Compares two passwords using the equals method apart of the String class
	 * Throws a Unmatched Exception otherwise returns from call.
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		// TODO Auto-generated method stub
		if (password.equals(passwordConfirm)) {
			return;
		}
		else {
			throw new UnmatchedException();
		}
		
	}
	
	/**
	 * Compares two passwords using the equals method from the String class.
	 * Returns true if the two passwords are equal.
	 * Returns false if they're not equal.
	 * @param password
	 * @param passwordConfirm
	 * @return boolean
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		// TODO Auto-generated method stub
		if (password.equals(passwordConfirm)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if the password passed in contains a upper alpha character
	 * by using the isUpperCase method apart of the Character class
	 * @param password
	 * @return boolean
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		// TODO Auto-generated method stub
		boolean has_upper_alpha = false; 
		int password_len = password.length();
		for (int i = 0; i < password_len; i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				has_upper_alpha = true;
				return has_upper_alpha;
			}
		}
		if (has_upper_alpha) {
			return has_upper_alpha;
		}
		else {
			throw new NoUpperAlphaException();
		}
	}
	
	/**
	 * Checks the password passed in to see if it contains a lower alpha character
	 * by using the isLowerCase method apart of the Character class.
	 * @param password
	 * @return boolean
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		// TODO Auto-generated method stub
		boolean has_lower_alpha = false;
		int password_len = password.length();
		for (int i = 0; i < password_len; i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				has_lower_alpha = true;
				return has_lower_alpha;
			}
		}
		if (has_lower_alpha) {
			return has_lower_alpha;
		}
		else {
			throw new NoLowerAlphaException();
		}
	}
	
	/**
	 * Checks if the password length is less than 6
	 * @param password
	 * @return boolean
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException{
		// TODO Auto-generated method stub
		int password_len = password.length();
		if (password_len < 6) {
			throw new LengthException();
		}
		else {
			return true;
		}
		
	}
	
	/**
	 * First checks if the password is valid.
	 * Then checks if the password is weak by checking if the length is 
	 * between 6 and 9 characters
	 * @param password
	 * @return boolean
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		// TODO Auto-generated method stub
		try {
			isValidPassword(password);
		}
		catch(Exception e) {
			throw new WeakPasswordException();
		}
		boolean has_six_or_nine_chars = hasBetweenSixAndNineChars(password);
		if (has_six_or_nine_chars) {
			throw new WeakPasswordException();
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Checks if the password has the same character in a sequence 
	 * by keeping track of the current character, previous character, and next character
	 * If the current character is ever equal to the previous character or next character
	 * then there is a sequence.
	 * @param password
	 * @return boolean
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		boolean no_same_char_in_seq = false;
		int current_char,previous_char,next_char;
		current_char = previous_char = next_char = -1;
		int password_len = password.length();
		for (int i = 0; i < password_len; i++) {
			current_char = password.charAt(i);
			if (i != password_len-1) {
				next_char = password.charAt(i+1);
			}else {
				next_char = -1;
			}
			if (i != 0) {
				previous_char = password.charAt(i-1); 
			}else {
				previous_char = -1;
			}
			if (current_char == previous_char || current_char == next_char) {
				throw new InvalidSequenceException();
			}
			
		}
		return no_same_char_in_seq;
		
	}
	/**
	 * Uses regex to match standard alphanumeric characters in a string
	 * if there is no special characters then the match will be true so we not match
	 * @param password
	 * @return boolean
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{
		String re = "[a-zA-Z0-9]*";
		Pattern pattern = Pattern.compile(re);
		Matcher matcher = pattern.matcher(password);
		boolean match = !matcher.matches();
		if (match) {
			return match;
		}
		else {
			throw new NoSpecialCharacterException();
		}
	}
	
	/**
	 * Checks if the password contains a digit by calling the isDigit method apart of the Character class
	 * @param password
	 * @return boolean
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		boolean has_digit = false;
		int password_len = password.length();
		for (int i = 0; i < password_len; i++) {
			if (Character.isDigit(password.charAt(i))) {
				has_digit = true;
				return has_digit;
			}
		}
		if (has_digit) {
			return has_digit;
		}else {
			throw new NoDigitException();
		}
	}
	
	/**
	 * Checks if the length of the password is between six and nine characters
	 * if it is then the password is weak
	 * @param password
	 * @return boolean
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		int password_len = password.length();
		if (password_len >=6 && password_len <=9) {
			return true;
		}
		else {
			return false;
		}
	}


}
