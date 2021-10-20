package calculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringCalculatorShould {
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

	@Test
	public void three_numbers_comma_delimited_should_be_summed() {
		assertEquals(6, calculator.add("1,2,3"));
	}

	@Test
	public void numbers_newline_delimited_should_be_summed() {
		assertEquals(6, calculator.add("1\n2,3"));
	}

	@Test
	public void negative_input_returns_exception() {
		try {
			calculator.add("-1,2");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -1");
		}

		try {
			calculator.add("2,-4,3,-5,-10");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -4,-5,-10");
		}
	}

//	@Test
//	public void numbers_greater_than_1000_are_ignored() {
//		assertEquals(15, calculator.add("1005,2,13"));
//		assertEquals(16, calculator.add("1005,5\n11"));
//		assertEquals(1002, calculator.add("1000,2"));
//	}

	@Test
	public void support_different_delimiters() {
		assertEquals(3, calculator.add("//;\n1;2"));
	}
	
	@Test
	public void numbers_between_1000_10000() {
//		assertEquals(11000, calculator.add("//[;]\n1000;2000;3000;10000"));
		assertEquals(6, calculator.add("1,2,9999,3"));
		assertEquals(11000, calculator.add("1000;2000;3000;10000"));

	}
}