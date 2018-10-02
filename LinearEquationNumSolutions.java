/**
 * Class to calculate the possible number of solutions to a linear equation of 
 * n variables, given all variables are positive integers or 0.
 * 
 * @author vavasing
 */
public class LinearEquationNumSolutions {
    public static int numSolutions(int coefficient[], int n, int balance) {
        // if balance becomes 0, solution is found, return 1
        if (balance == 0){
            return 1;
        }
        
        // If no coefficient is left or balance becomes less than 0, return 0
        if (balance < 0 || n < 0) {
            return 0;
        }
     
        // Case 1. include current coefficient coefficient[k] in solution and
        // recurse with remaining value (balance - coefficient[k])
        int inc = numSolutions(coefficient, n, balance - coefficient[n]);
     
        // Case 2. exclude current coefficient coefficient[k] from solution and 
        // recurse for remaining coefficients (k - 1)
        int exc = numSolutions(coefficient, n - 1, balance);
     
        // return total number of ways
        return inc + exc;
    }

    /* Tester method
     * The inputs here represent an equation of the form
     * 2x + 3y + 4z = 7;
     * which should have 
     */
    public static void main (String[] args) {
        int[] coefficient = { 2, 3, 4 };
        int len = coefficient.length;

        int balance = 7;

        System.out.println("Total number of solutions : " +
            numSolutions(coefficient, len - 1, balance));
    }
}  
