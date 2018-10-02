#include <iostream>
#include <vector>
using namespace std;

int cutRod(vector <int> price, int n)  { 
    vector <int> val(n+1); 
    val[0] = 0;
    for (int i = 1; i<=n; i++) { 
        int max_val = -1000000000;
        for (int j = 0; j < i; j++) 
            max_val = max(max_val,price[j] + val[i-j-1]); 
        val[i] = max_val; 
    } 
    return val[n]; 
}  

int main() { 
    vector<int> arr = {1, 5, 8, 9, 10, 17, 17, 20}; 
    int size = int(arr.size()); 
    cout << "Maximum Obtainable Value is " << cutRod(arr, size) << endl; 
}