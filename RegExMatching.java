import java.util.*;
import java.io.*;

class RegExMatching  {

	public void solveRegExMatching(String input, String pattern) {
		boolean[][] dp = new boolean[input.length()+1][pattern.length()+1];
		dp[0][0] = true;
		for(int i=1; i<dp[0].length; i++) {
			if(pattern.charAt(i-1) == '*')
				dp[0][i] = dp[0][i-2];
		}
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[i].length; j++) {
				char ch1 = input.charAt(i-1), ch2 = pattern.charAt(j-1);
				if(ch1 == ch2 || ch2 == '.')
					dp[i][j] = dp[i-1][j-1];
				else if(ch2 == '*') {
					dp[i][j] = dp[i][j-2];
					if(pattern.charAt(j-2) == '.' || pattern.charAt(j-2) == ch1)
						dp[i][j] = dp[i][j] || dp[i-1][j];
				}
				else
					dp[i][j] = false;
			}
		}
		System.out.println(dp[input.length()][pattern.length()]);
	}
	public static void main(String args[]) {
        String input = "xaabyc";
        String pattern = "xa*b.c";
        RegExMatching obj = new RegExMatching();
		obj.solveRegExMatching(input, pattern);
	}
}