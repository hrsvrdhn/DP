import java.util.*;
import java.io.*;

class SubsetSum {
	public static void printSolution(boolean[][] dp, int[] val) {
		int x = dp.length-1, y = dp[0].length-1;
		while(y > 0) {
			if(!dp[x-1][y]) {			
				System.out.print(val[x-1] + " ");
				y -= val[x-1];
			}
			x--;
		}
		System.out.println();
	}

	public static void findSubsetSum(int[] val, int target) {
		boolean[][] dp = new boolean[val.length+1][target+1];
		for(int i=0; i<dp.length; i++)
			dp[i][0] = true;

		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<=target; j++) {
				if(j < val[i-1])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] || dp[i-1][j-val[i-1]];
			}
		}
		
		if(dp[val.length][target])
			printSolution(dp, val);
		else
			System.out.println("Not possible.");
	}
	public static void main(String args[]) {
		int[] val = {2, 3, 5, 7, 9};
		int target = 11;
		findSubsetSum(val, target);
	}
}