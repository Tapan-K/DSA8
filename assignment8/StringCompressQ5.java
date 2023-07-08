package in.ineuron.assignment8;

public class StringCompressQ5 {
	public static int compress(char[] chars) {
		int n = chars.length;
		int writePtr = 0;
		int count = 1;

		for (int readPtr = 1; readPtr <= n; readPtr++) {
			if (readPtr < n && chars[readPtr] == chars[readPtr - 1]) {
				count++;
			} else {
				chars[writePtr++] = chars[readPtr - 1];
				if (count > 1) {
					String countStr = Integer.toString(count);
					for (char c : countStr.toCharArray()) {
						chars[writePtr++] = c;
					}
				}
				count = 1;
			}
		}

		return writePtr;
	}

	public static void main(String[] args) {
		// Q.5
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

		int newLength = compress(chars);
		System.out.println(newLength);

		for (int i = 0; i < newLength; i++) {
			System.out.print(chars[i] + " ");
		}

	}

}
