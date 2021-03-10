package se.knightspot.logmask;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Matcher {

	public static final List<Pattern> patternsToMatch = new ArrayList<Pattern>();
	static {
		patternsToMatch.add(Pattern.compile("jonas (\\d*)"));
		patternsToMatch.add(Pattern.compile("kalle"));

	}

	public Matcher() {

		patternsToMatch.add(Pattern.compile("JONAS \\S* (\\d*)"));
	}

	public boolean match(String str) {
		boolean returnValue = false;
		int listSize = patternsToMatch.size();
		int counter = 0;
		do {
			java.util.regex.Matcher isMatch = patternsToMatch.get(counter).matcher(str);
			returnValue = isMatch.find();
			if (returnValue) {
				StringBuffer buff = new StringBuffer();
				int maskStart = 0;
				int maskEnd = 0;
				if (isMatch.groupCount() > 0) {
					maskStart = isMatch.start(1);
					maskEnd = isMatch.end(1);
				}
				buff.append(str.substring(0, maskStart));
				for (int p = maskStart; p < maskEnd; p++) {
					buff.append("*");
				}
				buff.append(str.substring(maskEnd, str.length()));
				System.out.println(buff.toString());
			}
			counter++;
		} while (counter < listSize && !returnValue);
		return returnValue;
	}

	public String masker(String str) {
		String returnValue = str;
		boolean matching = false;
		int listSize = patternsToMatch.size();
		int counter = 0;
		while (counter < listSize && !matching) {
			java.util.regex.Matcher isMatch = patternsToMatch.get(counter).matcher(str);
			matching = (isMatch.find() && isMatch.groupCount() > 0);
			if (matching) {
				StringBuffer buff = new StringBuffer();

				int maskStart = isMatch.start(1);
				int maskEnd = isMatch.end(1);

				buff.append(str.substring(0, maskStart));
				for (int p = maskStart; p < maskEnd; p++) {
					buff.append("*");
				}
				buff.append(str.substring(maskEnd, str.length()));
				returnValue = buff.toString();
			}
			counter++;
		}
		return returnValue;
	}
}
