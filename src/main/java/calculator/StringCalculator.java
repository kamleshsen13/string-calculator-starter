package calculator;

class StringCalculator {

    private String emptyString = "";
	public int add(String input) {
		if (input.equals(emptyString)) {
			return 0;
		} 
		else 
			return -99;
	}

}