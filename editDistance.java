import java.util.*;
import java.io.*;

class editDistance {
	public static void printSolution(int[][] dp, String word1, String word2) {
		int x = dp.length-1, y = dp[0].length-1;
		while(x != 0 && y != 0) {
			if(word1.charAt(x-1) == word2.charAt(y-1)) {
				x--; y--;
			} else {
				if(dp[x][y] == dp[x-1][y-1] + 1) {
					System.out.println("Convert " + word1.charAt(x-1) + " to " + word2.charAt(y-1));
					x--; y--;
				} else if(dp[x][y] == dp[x-1][y] + 1) {
					System.out.println("Deleted " + word1.charAt(x-1));
					x--;
				} else {
					System.out.println("Deleted " + word2.charAt(y-1));
					y--;
				}
			}
		}
	}

	public static void minEditDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for(int i=0; i<=word1.length(); i++)
			dp[i][0] = i;
		for(int i=0; i<=word2.length(); i++)
			dp[0][i] = i;
		
		for(int i=1; i<=word1.length(); i++) {
			for(int j=1; j<=word2.length(); j++) {
				char ch1 = word1.charAt(i-1), ch2 = word2.charAt(j-1);
				if(ch1 == ch2)
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
			}
		}

		System.out.println("Minimum Edit distance = " + dp[word1.length()][word2.length()] + "\nOperations -:");
		printSolution(dp, word1, word2);
	}

	public static void main(String args[]) {
		String word1 = "abcdef";
		String word2 = "azced";
		minEditDistance(word1, word2);
	}
}