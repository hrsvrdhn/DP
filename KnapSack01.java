import java.util.*;
import java.io.*;

class KnapSack01 {
	public static void main(String args[]) {
		int[][] items = {
			{1, 1},
			{3, 4},
			{4, 5},
			{5, 7}
		};
		int max_weight = 7;

		int[][] dp = new int[items.length+1][max_weight+1];
		for(int i=0; i<items.length; i++)
			dp[i][0] = 0;
		for(int i=0; i<=max_weight; i++)
			dp[0][i] = 0;

		for(int i=1; i<=items.length; i++) {
			for(int j=1; j<=max_weight; j++) {
				int c = items[i-1][0], w = items[i-1][1]; 
				if(j < c)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j], w + dp[i-1][j-c]);
			}
		}
		// for(int i=0; i<dp.length; i++) {
		// 	for(int j=0; j<dp[i].length; j++)
		// 		System.out.print(dp[i][j] + " ");
		// 	System.out.println();
		// }
		System.out.println("Answer = " + dp[items.length][max_weight]);
	}
}