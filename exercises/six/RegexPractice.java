package six;

import java.util.ArrayList;
import java.util.List;

public class RegexPractice {
	
	public String[] extractNumbers(String equation) {
		String[] strings = equation.split(" ");
		String[] numbers = new String[4];
		Integer j = 0;
		
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].matches("(\\d+)")) {
				numbers[j] = strings[i];
				j++;
			}
		}
		return numbers;
	}
	
	public String[] extractOperators(String equation) {
		String[] strings = equation.split(" ");
		String[] operators = new String[3];
		Integer j = 0;
		
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].matches("[\\W]")) {
			//if(s.matches("[\\+\\-\\.\\*\\/]")) {
				operators[j] = strings[i];
				j++;
			}
		}
		return operators;
	}
}
