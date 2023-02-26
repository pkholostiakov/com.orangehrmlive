package utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	
	private static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			  + "abcdefghijklmnopqrstuvwxyz"
	          + "0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";

	public static String randomStr(int symbols) {
		return RandomStringUtils.random(symbols,characters);
	}
	/**
	 * Return integer number from low(included) to (high)included
	 * @low is included
	 * @high is included
	 * @return integer number
	 */
	public static int randomIntBeetween(int low,int high) {
		return (int)((Math.random()*high)+low);
	}
	
	public static String randomValidPassword() {
		StringBuilder password = new StringBuilder();
		String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String SMALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	    String NUMBERS = "0123456789";
	    String SYMBOLS = "!@#$%^&*_=+-/";
	    password.append(getRandomCharacter(CAPITAL_LETTERS));
        password.append(getRandomCharacter(SMALL_LETTERS));
        password.append(getRandomCharacter(NUMBERS));
        password.append(getRandomCharacter(SYMBOLS));
        
        for (int i = 0; i < 4; i++) {
            password.append(getRandomCharacter(CAPITAL_LETTERS + SMALL_LETTERS + NUMBERS + SYMBOLS));
        }
        return password.toString();
	}
	
	private static char getRandomCharacter(String characterSet) {
        int randomIndex = new Random().nextInt(characterSet.length());
        return characterSet.charAt(randomIndex);
    }
}
