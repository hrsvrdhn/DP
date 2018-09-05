import java.util.*;
import java.io.*;

class LIS {
	public static void printSolution(int[] dp, int[] track, int[] seq, int start) {
		Stack<Integer> stck = new Stack<Integer>();
		while(true) {
			stck.push(seq[start]);
			if(dp[start] == 1) break;
			start = track[start];
		} 
		while(stck.isEmpty() == false) {
			System.out.print(stck.pop() + " ");
		}
		System.out.println();
	}

	public static void LongestIncreasingSubsequence(int[] seq) {
		int[] dp = new int[seq.length];
		int[] track = new int[seq.length];
		Arrays.fill(dp, 1);

		int max_ind = 0;
		for(int i=0; i<dp.length; i++) {
			for(int j=i+1; j<dp.length; j++) {
				if(seq[j] > seq[i] && dp[j] < dp[i]+1) {
					dp[j] = dp[i] + 1;
					track[j] = i;
				}
			}
			if(dp[i] > dp[max_ind])
				max_ind = i;
		}
		System.out.print("Length of LIS = " + dp[max_ind] + "\nSequence = ");
		printSolution(dp, track, seq, max_ind);
	}
	public static void main(String args[]) {
		int[] seq = {3, 2, 4, 6};
		LongestIncreasingSubsequence(seq);
	}
}