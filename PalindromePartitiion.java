//PALINDROME PARTITIONING
//You are given a string. You need to partition that string such that each substrings after partitioning would be palindromic string. You have to do this work with minimum number of partitioning.

//Input Format:
//First line contains integer t which is number of test case. For each test case, it contains a string S

//Output Format:
//Print the minimum number of partitioning.
//Sample Input:
//1
//ababbbabbababa
//Sample Output:
//3

public class PalindromePartitiion {
	public static void main(String[] args) {

		String str = "ababbbabbababacdbdccc";
		System.out
				.println(palindromePartitionTD(str, 0, str.length() - 1, new int[str.length() + 1][str.length() + 1]));
		System.out.println(palindromePartitionBU(str));

	}

	public static boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;

		}

		return true;
	}

	public static int palindromePartitionTD(String str, int si, int ei, int[][] strg) {

		String ss = str.substring(si, ei + 1);
		if (isPalindrome(ss)) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k < ei; k++) {

			int fc = palindromePartitionTD(str, si, k, strg);
			int sc = palindromePartitionTD(str, k + 1, ei, strg);
			int ans = fc + sc;

			if (ans < min) {
				min = ans;
			}
		}

		strg[si][ei] = min + 1;
		return min + 1;
	}

	public static int palindromePartitionBU(String str) {

		int n = str.length();
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (isPalindrome(str.substring(si, ei + 1))) {
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = si; k < ei; k++) {

						int fc = strg[si][k];
						int sc = strg[k + 1][ei];
						int ans = fc + sc;

						if (ans < min) {
							min = ans;
						}
					}

					strg[si][ei] = min + 1;
				}

			}
		}

		// for (int[] val : strg) {
		// for (int val1 : val) {
		// System.out.print(val1 + " ");
		// }
		// System.out.println();
		// }
		return strg[0][n - 1];

	}

}
