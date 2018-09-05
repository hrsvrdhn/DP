import java.util.*;
import java.io.*;

class SubRectangularMatrixWithMaximumSum  {
	class Result {
		int maxSum;
		int upBound;
		int lowBound;
		int rightBound;
		int leftBound;

		@Override
		public String toString() {
            return "Result [maxSum=" + maxSum + ", leftBound=" + leftBound
                    + ", rightBound=" + rightBound + ", upBound=" + upBound
                    + ", lowBound=" + lowBound + "]";
		}
	}

	public void solveSubRectangularMatrixWithMaximumSum(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] temp = new int[rows];
		Result result = new Result();
		for(int l=0; l<cols; l++) {
			Arrays.fill(temp, 0);
			for(int r=l; r<cols; r++) {
				for(int i=0; i<rows; i++)
					temp[i] += matrix[i][r];
				KadaneResult kadaneResult = kadane(temp);
				if(kadaneResult.maxSum > result.maxSum) {
					result.maxSum = kadaneResult.maxSum;
					result.upBound = kadaneResult.start;
					result.lowBound = kadaneResult.end;
					result.leftBound = l;
					result.rightBound = r;
				}
			}
		}
		System.out.println(result);
	}

	class KadaneResult {
		int maxSum;
		int start;
		int end;
		public KadaneResult(int a, int b, int c) {
			maxSum = a;
			start = b;
			end = c;
		}
	}

	public KadaneResult kadane(int[] arr) {
		int max = 0;
		int maxStart = -1;
		int maxEnd = -1;
		int currentStart = 0;
		int maxSoFar = 0;
		for(int i=0; i<arr.length; i++) {
			maxSoFar += arr[i];
			if(maxSoFar < 0) {
				maxSoFar = 0;
				currentStart = i+1;
			}
			if(max < maxSoFar) {
				max = maxSoFar;
				maxStart = currentStart;
				maxEnd = i;
			}
		}
		return new KadaneResult(max, maxStart, maxEnd);
	}

	public static void main(String args[]) {
        int input[][] = {{ 2,  1, -3, -4,  5},
                         { 0,  6,  3,  4,  1},
                         { 2, -2, -1,  4, -5},
                         {-3,  3,  1,  0,  3}};
        SubRectangularMatrixWithMaximumSum obj = new SubRectangularMatrixWithMaximumSum();
		obj.solveSubRectangularMatrixWithMaximumSum(input);
	}
}