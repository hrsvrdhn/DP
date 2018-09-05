import java.util.*;
import java.io.*;

class MaxHistogramArea  {

	public void solveMaxHistogramArea(int[] input) {
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
		System.out.println("Answer = " + maxArea);
	}

	public static void main(String args[]) {
        int input[] = {1, 4, 2, 3, 3};
        MaxHistogramArea obj = new MaxHistogramArea();
		obj.solveMaxHistogramArea(input);
	}
}