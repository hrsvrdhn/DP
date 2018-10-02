/**
Problem: https://en.wikipedia.org/wiki/Knapsack_problem#Unbounded_knapsack_problem
*/ 
public class UnboundedKnapsack {
	public static void main(String[] args) {
        int C = 17;
        int[] wt = {4, 3, 5, 7, 11};
        int[] val = {5, 3, 6, 2, 7};
        int N = wt.length;
        System.out.println("Max Profit: " + unboundedKnapsack(C, N, wt, val));
    }

    /**
     * 
     * @param C: total weight
     * @param N: N items
     * @param wt: weights
     * @param val: values
     * @return: maximum value of items whose weight does not exceed C
     */
    public static int unboundedKnapsack(int C, int N, int[] wt, int[] val){

        // dp[i]: the current "best "solution" (max value) for cap. of i
        int[] dp = new int[C + 1];

        for (int i = 0; i <= C; i ++){
            for (int j = 0; j < N; j ++){
                if(i >= wt[j]){
                    dp[i] = Math.max(dp[i], val[j] + dp[i - wt[j]]);
                }
            }
        }
        return dp[C];
    }
}