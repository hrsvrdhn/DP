/*
Given an array of n prime numbers, calculate numbers upto n which are divisible by any of these
This has basic inclusion-exclusion principle implemetation using recursion
You can also implement  it dynamically usinh recursion.
*/

#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;

int arr[10000];// Array to store all factors
int n;//Number of elements in array
int N;// Range
 
ll rec(int i,ll cur)
{
    ll temp=arr[i]*1LL,ret=0;
    if(temp*cur >N || i==n) return 0;
    
    ret+=(N/cur/temp);
    ret += rec(i + 1, cur);
    ret -= rec(i + 1, cur  * temp);
    return ret;

} 


int main()
{
      cin>>n;
      for(int i=0;i<n;i++)cin>>arr[i];
      cin>>N;
      ll ans=rec(0,1);
      cout<<ans<<endl;

}

