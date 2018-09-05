import java.util.*;
import java.io.*;

class longestPalindromicSubsequence {
	public static void printSolution(int s, int e, int[][] dp, String word) {
		if(s == e) {
			System.out.print(word.charAt(s));
			return;
		}
		if(word.charAt(s) == word.charAt(e)) {
			System.out.print(word.charAt(s));
			printSolution(s+1, e-1, dp, word);
			System.out.print(word.charAt(e));
		}
		else if(s+1 < dp.length && dp[s][e] == dp[s+1][e])
			printSolution(s+1, e, dp, word);
		else
			printSolution(s, e-1, dp, word);
	}

	public static void findLongestPalindromicSubsequence(String word) {
		int[][] dp = new int[word.length()][word.length()];
		for(int i=0; i<dp.length; i++)
			dp[i][i] = 1;
		
		for(int l=2; l<=dp.length; l++) {
			for(int i=0; i<dp.length-l+1; i++) {
				int j=i+l-1;
				if(word.charAt(i) == word.charAt(j))
					dp[i][j] = 2 + dp[i+1][j-1];
				else
					dp[i][j] = Math.max(i+1 < word.length() ? dp[i+1][j] : 0, j-1 >= 0 ? dp[i][j-1] : 0);
			}
		}
		System.out.println("Length of longest palindromic subsequence is " + dp[0][dp[0].length-1]);
		printSolution(0, dp[0].length-1, dp, word);
	}

	public static void main(String args[]) {
		String word = "mascdam";
		findLongestPalindromicSubsequence(word);
	}
}