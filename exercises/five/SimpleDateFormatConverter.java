package five;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatConverter implements Converter<Date> {
	SimpleDateFormat forParsing;
	SimpleDateFormat forFormatting;
	
	public SimpleDateFormatConverter() {
		this.forParsing = new SimpleDateFormat("d MMMM yyyy");
		this.forFormatting = new SimpleDateFormat("d MMMM yyyy");
	}
	
	public SimpleDateFormatConverter(SimpleDateFormat sdf) {
		this.forParsing = sdf;
		this.forFormatting = sdf;
	}
	
	public SimpleDateFormatConverter(SimpleDateFormat forParsing, SimpleDateFormat forFormatting) {
		this.forParsing = forParsing;
		this.forFormatting = forFormatting;
	}
	
	@Override
	public Date parse(String fromString) {
		try {
			Date d = forParsing.parse(fromString);
			System.out.println(d);
			return d;
		}
		catch(ParseException e) {
			System.out.println("The date cannot be parsed.");
			return null;
		}
	}

	@Override
	public String format(Date fromObject) {
		return forFormatting.format(fromObject).toString();
	}

}
