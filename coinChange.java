import java.util.*;
import java.io.*;

class coinChange {
	public static void printSolution(int[] track, int[] coins) {
		int ind = track.length-1;
		while(ind > 0) {
			System.out.print(coins[track[ind]] + " ");
			ind -= coins[track[ind]];		
		}
		System.out.println();
	}

	public static void coinChangeDP(int[] coins, int target) {
		int[] dp = new int[target+1];
		int[] track = new int[target+1];
		Arrays.fill(dp, (1<<30));
		dp[0] = 0;

		for(int i=0; i<coins.length; i++) {
			for(int j=coins[i]; j<=target; j++) {
				if(dp[j] > dp[j-coins[i]] + 1) {
					dp[j] = dp[j-coins[i]] + 1;
					track[j] = i;
				}
			}
		}
		if(dp[target] >= (1<<30))
			System.out.println("Not possible.");
		else {
			System.out.print("Min coins required = " + dp[target] + "\n Coins = ");
			printSolution(track, coins);
		}
	}
	public static void main(String args[]) {
		int[] coins = {3, 2, 4, 6};
		int target = 19;
		coinChangeDP(coins, target);
	}
}