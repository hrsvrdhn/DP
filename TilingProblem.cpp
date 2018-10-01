/*
Given 2*n matrix, find number of ways to fill it using 1*2 size tiles
https://www.geeksforgeeks.org/tiling-problem/

*/


#include<iostream>
using namespace std;

int main()
{
  cout<<"Enter the size of n=";
  int n;cin>>n;
  int g[n+1];
  g[0]=1,g[1];
  for(int i=2;i<=n;i++)
   g[i]=g[i-2]+g[i-1];
  
  cout<<g[n]<<endl;
  
}
