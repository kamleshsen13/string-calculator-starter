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
}
