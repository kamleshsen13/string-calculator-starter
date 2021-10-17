package calculator;

class StringCalculator {

    private String emptyString = "";
	
	
	
	public int add(String input) {
		String[] numbers = input.split(",");
		
		if (isEmpty(input)) {
			return 0;
		} 
		if(input.length()==1){
			return toInt(input);
		}
		else {
			return sum(numbers[0],numbers[1]);
		}
	}
	
	private int sum(String num1, String num2)
	{
		return Integer.parseInt(num1)+Integer.parseInt(num2);
	}

    private boolean isEmpty(String input)
	{ 
	  return input.isEmpty();
	}
	
	private int toInt(String number) {
		return Integer.parseInt(number);
	}


}