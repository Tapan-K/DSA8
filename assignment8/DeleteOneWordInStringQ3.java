package in.ineuron.assignment8;

public class DeleteOneWordInStringQ3 {
	public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D array to store the minimum number of steps
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row and first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the remaining cells
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word1 = "sea";
        String word2 = "eat";

        int minSteps = minDistance(word1, word2);
        System.out.println(minSteps);

	}

}
