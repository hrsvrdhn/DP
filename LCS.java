import java.util.*;
import java.io.*;

class LCS {
	public static void main(String args[]) {
		String word1 = "abcdaf";
		String word2 = "acbcf";
		int N = word1.length();
		int M = word2.length();

		int[][] dp = new int[N+1][M+1];
		for(int i=0; i<=N; i++)
			dp[i][0] = 0;
		for(int i=0; i<=M; i++)
			dp[0][i] = 0;

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		// for(int i=0; i<dp.length; i++) {
		// 	for(int j=0; j<dp[i].length; j++)
		// 		System.out.print(dp[i][j] + " ");
		// 	System.out.println();
		// }

		String ans = "";
		int x = N, y = M;
		while(x != 0 && y != 0) {
			if(word1.charAt(x-1) == word2.charAt(y-1)) {
				ans = word1.charAt(x-1) + ans;
				x--;y--;
			} else {
				if(dp[x][y] == dp[x-1][y])
					x--;
				else
					y--;
			}
		}
		System.out.println("Answer = " + ans);
	}
}