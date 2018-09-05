import java.util.*;
import java.io.*;

class MaxSizeSubSquareBinaryMatrix  {

	public void solveMaxSizeSubSquareBinaryMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows+1][cols+1];
		int ans = 0;
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=cols; j++) {
				if(matrix[i-1][j-1] == 1)
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println("Answer = " + ans);
	}

	public static void main(String args[]) {
        int input[][] = {{ 0, 0, 1, 1, 1},
                         { 1, 0, 1, 1, 1},
                         { 0, 1, 1, 1, 1},
                         { 1, 0, 1, 1, 1}};
        MaxSizeSubSquareBinaryMatrix obj = new MaxSizeSubSquareBinaryMatrix();
		obj.solveMaxSizeSubSquareBinaryMatrix(input);
	}
}