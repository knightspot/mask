package se.knightspot.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

public class MyEncoder extends PatternLayoutEncoderBase<ILoggingEvent> {
	@Override
	public void start() {
		   MyPattern patternLayout = new MyPattern();
	        patternLayout.setContext(context);
	        patternLayout.setPattern(getPattern());
	        patternLayout.setOutputPatternAsHeader(outputPatternAsHeader);
	        patternLayout.start();
	        this.layout = patternLayout;
	        super.start();
	}

}
