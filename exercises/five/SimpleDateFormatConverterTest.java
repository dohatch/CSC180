package five;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class SimpleDateFormatConverterTest {

	@Test
	public void testFormat() {
		Converter<Date> dates = new SimpleDateFormatConverter();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);

		Date d = cal.getTime();
		String formatted = dates.format(d);
		System.out.println(formatted);

		Assert.assertEquals("21 October 2014", formatted);
		cal.set(Calendar.DATE, 2);
		d = cal.getTime();

		Assert.assertEquals("2 October 2014", dates.format(d));
	}
	
	@Test
	public void testParse() {
		Converter<Date> dates = new SimpleDateFormatConverter();
		
		String d = "21 October 2014";
		
		Assert.assertEquals("21 October 2014", dates.format(dates.parse(d)));
		
	}

}
