package six;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RegexPracticeTest {
	RegexPractice rp = new RegexPractice();
	@Test
	public void testExtractNumbers() {
		String equation = "1 + 3 * 9 / 3";
		String[] actual = rp.extractNumbers(equation);
		String[] expected = new String[4];
		expected[0] = "1";
		expected[1] = "3";
		expected[2] = "9";
		expected[3] = "3";
		
		for(Integer i = 0; i < expected.length; i++) {
			//Assert.assertNotNull(actual[i]);
			Assert.assertEquals(expected[i], actual[i]);
		}
	}
	
	@Test
	public void testExtractOperators() {
		String equation = "1 + 3 * 9 / 3";
		String[] actual = rp.extractOperators(equation);
		String[] expected = new String[3];
		expected[0] = "+";
		expected[1] = "*";
		expected[2] = "/";
		
		for(Integer i = 0; i < expected.length; i++) {
			//Assert.assertNotNull(actual[i]);
			Assert.assertEquals(expected[i], actual[i]);
		}
	}
}
