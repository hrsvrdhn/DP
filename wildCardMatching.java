import java.util.*;
import java.io.*;

class wildCardMatching  {

	public void solveWildCardMatching(String input, String pattern) {
		boolean[][] dp = new boolean[input.length()+1][pattern.length()+1];
		int i = 1;
		dp[0][0] = true;
		while(pattern.charAt(i-1) == '*') {
			dp[0][i] = true;
			i++;
		}
		for(i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				char ch1 = input.charAt(i-1), ch2 = pattern.charAt(j-1);
				if(ch1 == ch2 || ch2 == '?')
					dp[i][j] = dp[i-1][j-1];
				else if(ch2 == '*')
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				else
					dp[i][j] = false;
			}
		}
		System.out.println(dp[input.length()][pattern.length()]);
	}
	public static void main(String args[]) {
        String input = "xaylmz";
        String pattern = "x?y*z";
        wildCardMatching obj = new wildCardMatching();
		obj.solveWildCardMatching(input, pattern);
	}
}