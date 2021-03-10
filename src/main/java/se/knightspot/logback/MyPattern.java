package se.knightspot.logback;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import se.knightspot.logmask.Matcher;

public class MyPattern extends PatternLayout {

	private Matcher matcher = new Matcher();
	@Override
	public String doLayout(ILoggingEvent event) {
		String str = super.doLayout(event);
		return matcher.masker(str);
	}
}
