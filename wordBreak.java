import java.util.*;
import java.io.*;

class wordBreak  {
	public void solveWordBreak(String word, Set<String> dictionary) {
		boolean[][] dp = new boolean[word.length()][word.length()];
		for(int i=0; i<dp.length; i++) {
			if(dictionary.contains(word.substring(i, i+1)))
				dp[i][i] = true;
		}
		for(int l=2; l<=dp.length; l++) {
			for(int i=0; i<dp.length-l+1; i++) {
				int j = i + l - 1;
				if(dictionary.contains(word.substring(i, j+1))) {
					dp[i][j] = true;
					continue;
				}
				for(int k=i+1; k<=j; k++) {
					if(dp[i][k-1] && dp[k][j]) {
						dp[i][j] = true;
						break;
					}
				}
			}
		}
		System.out.println(dp[0][dp[0].length-1] ? "Possible" : "Not possible");
	}
	public static void main(String args[]) {
        wordBreak obj = new wordBreak();
        
        Set<String> s = new HashSet<>();
		s.add("interview");
		s.add("my");
		s.add("trainer");
		obj.solveWordBreak("myinterviewtrainer", s);
	}
}