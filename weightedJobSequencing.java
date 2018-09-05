import java.util.*;
import java.io.*;

class weightedJobSequencing {
	public static void solve(int[] profits, int[][] time_interval) {
		int[] dp = new int[profits.length];
		for(int i=0; i<dp.length; i++)
			dp[i] = profits[i];
		int max_ind = 0;		
		for(int i=1; i<dp.length; i++) {
			for(int j=0; j<i; j++) {
				if(time_interval[j][1] > time_interval[i][0]) continue;
				dp[i] = Math.max(dp[i], dp[j] + profits[i]);
			}
			if(dp[i] > dp[max_ind])
				max_ind = i;
		}

		System.out.println("Max profit is " + dp[max_ind]);
	}

	public static void main(String args[]) {
		int[] profits = {5, 6, 5, 4, 11, 2};
		int[][] time_interval = {
			{1, 3},
			{2, 5},
			{4, 6},
			{6, 7},
			{5, 8},
			{7, 9}
		};
		// Sorting by their endtimes
		Arrays.sort(time_interval, new Comparator<int[]>(){
			@Override
			public int compare(final int[] a, final int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});

		solve(profits, time_interval);
	}
}