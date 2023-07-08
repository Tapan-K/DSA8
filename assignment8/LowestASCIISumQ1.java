package in.ineuron.assignment8;

public class LowestASCIISumQ1 {
	public static int minimumDeleteSum(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		// Create a 2D array to store the minimum ASCII sum
		int[][] dp = new int[m + 1][n + 1];

		// Fill the first row and first column
		for (int i = 1; i <= m; i++) {
			dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
		}

		// Fill the remaining cells
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int deleteS1 = dp[i - 1][j] + s1.charAt(i - 1);
					int deleteS2 = dp[i][j - 1] + s2.charAt(j - 1);
					dp[i][j] = Math.min(deleteS1, deleteS2);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		// Q.1

		String s1 = "sea";
		String s2 = "eat";

		int lowestASCIISum = minimumDeleteSum(s1, s2);
		System.out.println(lowestASCIISum);

	}

}
