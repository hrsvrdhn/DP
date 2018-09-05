import java.util.*;
import java.io.*;

class optimalBinarySearchTree {
	public static void printSolution(boolean[][] dp, int[] val) {
	}

	public static void findSubsetSum(int[] val) {
		int[][] dp = new int[val.length][val.length];
		for(int i=0; i<dp.length; i++)
			dp[i][i] = val[i];

		for(int l=2; l<=dp.length; l++) {
			for(int i=0; i<dp.length-l+1; i++) {
				int j=i+l-1, summ = 0, cost;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<=j; k++) {
					summ += val[k];
					if(k == i)
						cost = dp[k+1][j];
					else if(k == j)
						cost = dp[i][j-1];
					else
						cost = dp[i][k-1] + dp[k+1][j];
					dp[i][j] = Math.min(dp[i][j], cost);
				}
				dp[i][j] += summ;
			}
		}
		System.out.println("Answer = " + dp[0][dp[0].length-1]);
	}
	public static void main(String args[]) {
		int[] val = {4, 2, 6, 3};
		findSubsetSum(val);
	}
}