using System; 
class CuttingARod { 
      
    static int cutRod(int []price, int n) 
    { 
        if (n <= 0) 
            return 0; 
        int max_val = int.MinValue; 
        
        for (int i = 0; i < n; i++) 
            max_val = Math.Max(max_val, price[i] +  
                        cutRod(price, n - i - 1)); 
  
        return max_val; 
    } 
  
    // Driver Code 
    public static void Main() 
    { 
        int []arr = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.Length; 
        Console.WriteLine("Maximum Obtainable Value is "+ 
                                        cutRod(arr, size)); 
    } 
} 