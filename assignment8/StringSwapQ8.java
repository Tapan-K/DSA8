package in.ineuron.assignment8;

public class StringSwapQ8 {
	public static boolean isSwappable(String s, String goal) {
		int n = s.length();
		int diffCount = 0;
		int[] diffIndices = new int[2];

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				if (diffCount >= 2) {
					return false;
				}
				diffIndices[diffCount] = i;
				diffCount++;
			}
		}

		if (diffCount != 2) {
			return false;
		}

		return s.charAt(diffIndices[0]) == goal.charAt(diffIndices[1])
				&& s.charAt(diffIndices[1]) == goal.charAt(diffIndices[0]);
	}

	public static void main(String[] args) {
		// Q.8
		String s = "ab";
		String goal = "ba";

		boolean isSwappable = isSwappable(s, goal);
		System.out.println(isSwappable);

	}

}
