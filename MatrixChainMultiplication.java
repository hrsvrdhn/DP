import java.util.*;
import java.io.*;

class MatrixChainMultiplication {
	public static void printBrackets(int[][] bracket, int i, int j) {
		if(i == j) {
			System.out.print(i);
			return;
		}
		System.out.print("(");
		printBrackets(bracket, i, bracket[i][j]);
		printBrackets(bracket, bracket[i][j]+1, j);
		System.out.print(")");
	}

	public static int findMinCost(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		int[][] bracket = new int[arr.length][arr.length];

		for(int l=2; l<arr.length; l++) {
			for(int i=1; i<arr.length-l+1; i++) {
				int j = i+l-1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++) {
					int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
					if(cost < dp[i][j])
						dp[i][j] = cost;
						bracket[i][j] = k;
				}
			}
		}
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		printBrackets(bracket, 1, arr.length-1);
		return dp[1][arr.length-1];
	}


	public static void main(String args[]) {
		int arr[] = {2, 3, 6, 4, 5};
		int cost = findMinCost(arr);
		System.out.println("Answer ==> " + cost);
	}
}