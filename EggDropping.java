import java.util.*;
import java.io.*;

class EggDropping {
	public static void solve(int floors, int eggs) {
		int[][] dp = new int[eggs][floors+1];
		for(int i=0; i<=floors; i++)
			dp[0][i] = i;
		for(int i=1; i<eggs; i++) {
			for(int j=1; j<=floors; j++) {
				if(j < i) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=1; k<=j; k++)
					dp[i][j] = Math.min(dp[i][j], 1+Math.max(dp[i-1][k-1], dp[i][j-k]));
			}
		}
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}	
	}

	public static void main(String args[]) {
		int floors = 6, eggs = 2;
		solve(floors, eggs);
	}
}