package calculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class StringCalculatorShould {

    private StringCalculator calculator;

	@Before
	public void initializer() {
		calculator = new StringCalculator();
	}
	
	@Test
	public void empty_string_should_return_0(){
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void string_with_single_number_should_return_number_as_int() {
		assertEquals(1, calculator.add("1"));
		assertEquals(55, calculator.add("55"));
	}

	@Test
	public void two_numbers_comma_delimited_should_be_summed() {
		assertEquals(3, calculator.add("1,2"));
		assertEquals(66, calculator.add("41,25"));
	}

	
}
