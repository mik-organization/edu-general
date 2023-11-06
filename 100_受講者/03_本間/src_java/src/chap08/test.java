package chap08;

import java.text.NumberFormat;
import java.util.Locale;

public class test {

	public static void main(String[] args) {
		
		int amount = 10000;
		
		Locale chinaLocale = Locale.CHINA;
		
		NumberFormat chinaCurrencyFormat = NumberFormat.getCurrencyInstance(chinaLocale);
		String formattedAmount = chinaCurrencyFormat.format(amount);
		System.out.println(formattedAmount);
	}

}
