package calculator;

public class StringCalculator {

	private String emptyString = "";
	private String otherDelimiters = "//(.*)\n(.*)";

	public int add(String input) {
		if (input.equals(emptyString)) {
			return 0;
		} 
		else {
			String delimiter = ",";
			if (input.matches(otherDelimiters)) {
				delimiter = Character.toString(input.charAt(2));
				input = input.substring(4);
			}
			String numList[] = splitNumbers(input, delimiter + "|;|\n");
			return sum(numList);
		}
	}

	private int toInt(String number) {
		return Integer.parseInt(number);
	}

	private String[] splitNumbers(String numbers, String divider) {
		return numbers.split(divider);
	}

//	private int sum(String[] numbers) {
//		int total = 0;
//		String negString = emptyString;
//
//		for (String number : numbers) {
//			if (toInt(number) < 0) {
//				if (negString.equals(emptyString))
//					negString = number;
//				else
//					negString += ("," + number);
//			}
//			if (toInt(number) <= 1000)
//				total += toInt(number);
//		}
	
	private int sum(String[] numbers) {
		int total = 0;
		String negString = emptyString;

		for (String number : numbers) {
			if (toInt(number) < 0) {
				if (negString.equals(emptyString))
					negString = number;
				else
					negString += ("," + number);
			}
			if(!(toInt(number)<10000 && toInt(number)>1000))
				continue;
			else if (toInt(number) <= 1000 )
				total += toInt(number);
		}

		if (!negString.equals(emptyString)) {
			throw new IllegalArgumentException("negatives not allowed: " + negString);
		}
		return total;
	}

}
