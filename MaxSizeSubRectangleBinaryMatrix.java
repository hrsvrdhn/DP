import java.util.*;
import java.io.*;

class MaxSizeSubRectangleBinaryMatrix  {

	public int solveMaxHistogramArea(int[] input) {
		Stack<Integer> stck = new Stack<>();
		int maxArea = 0, area;
		for(int i=0; i<input.length; i++) {
			while(stck.isEmpty() == false && input[stck.peek()] > input[i]) {
				int top = stck.pop();
				if(stck.isEmpty())
					area = input[top] * i;
				else
					area = input[top] * (i - stck.peek() - 1);
				maxArea = Math.max(maxArea, area);
			}
			stck.push(i);
		}
		while(stck.isEmpty() == false) {
			int top = stck.pop();
			if(stck.isEmpty())
				area = input[top] * input.length;
			else
				area = input[top] * (input.length - stck.peek() - 1);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	public void solveMaxSizeSubRectangleBinaryMatrix(int[][] input) {
		int rows = input.length;
		int cols = input[0].length;
		int temp[] = new int[cols];
		int maxArea = 0;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(input[i][j] == 0)
					temp[j] = 0;
				else
					temp[j] += 1;
			}
			maxArea = Math.max(maxArea, solveMaxHistogramArea(temp));
		}
		System.out.println("Answer = " + maxArea);
	}
	public static void main(String args[]) {
        int input[][] = {{ 0, 0, 1, 1, 1},
                         { 1, 0, 1, 1, 1},
                         { 0, 1, 1, 1, 1},
                         { 1, 0, 1, 1, 1}};
        MaxSizeSubRectangleBinaryMatrix obj = new MaxSizeSubRectangleBinaryMatrix();
		obj.solveMaxSizeSubRectangleBinaryMatrix(input);
	}
}