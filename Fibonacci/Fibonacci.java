//Java program for Fibonacci Series using Space 
import java.util.*;
class fibonacci 
{ 
    static int fib(int n) 
    { 
        /* Declare an array to store Fibonacci numbers. */
    int f[] = new int[n+2]; // 1 extra to handle case, n = 0 
    int i; 
       
    /* 0th and 1st number of the series are 0 and 1*/
    f[0] = 0; 
    f[1] = 1; 
      
    for (i = 2; i <= n; i++) 
    { 
       /* Add the previous 2 numbers in the series 
         and store it */
        f[i] = f[i-1] + f[i-2]; 
    } 
       
    return f[n]; 
    
    } 
  
    public static void main (String args[]) 
    { 
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n)); 
    } 
}
