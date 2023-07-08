package in.ineuron.assignment8;

import java.util.*;

public class DecodeEncodedStringQ7 {
	public static String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder currentString = new StringBuilder();
		int count = 0;

		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				count = count * 10 + (ch - '0');
			} else if (ch == '[') {
				countStack.push(count);
				stringStack.push(currentString);
				currentString = new StringBuilder();
				count = 0;
			} else if (ch == ']') {
				StringBuilder decodedString = stringStack.pop();
				int repeatCount = countStack.pop();
				for (int i = 0; i < repeatCount; i++) {
					decodedString.append(currentString);
				}
				currentString = decodedString;
			} else {
				currentString.append(ch);
			}
		}

		return currentString.toString();
	}

	public static void main(String[] args) {
		// Q.7
		String s = "3[a]2[bc]";

		String decodedString = decodeString(s);
		System.out.println(decodedString);

	}

}
