/*
PROBLEM LINK:
https://www.hackerrank.com/contests/goldman-sachs-womens-codesprint/challenges/party-invitations
*/


/*
<------------------------------------------------------------------------------------------------------------>
                              ANJAN AGARWALA   @anjn98                      
                                JADAVPUR UNIVERSITY                           
<------------------------------------------------------------------------------------------------------------>
#include<geeksforgeeks.h>
#include<stackoverflow.h>
*/
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
#define FIO ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
ll power(ll x,ll y,ll p){ll r=1;x=x%p;while(y){if(y&1)r= r*x%p;y=y>>1;x=x*x%p;}return r;}
#define all(v) v.begin(),v.end()
#define PR(a) cout<<"("<<a<<")";
#define ED cout<<'\n';
#define loop(j,a,n)  for(int j=a;j<=n;j++)
#define loop1(j,a,n)  for(int j=a;j>=n;j--)
#define fr1(j,n)  for(int j=0;j<n;j++)
#define fr(n)  for(int i=0;i<n;i++)
#define fra(s) for(auto x:s)
#define PB push_back
#define MP make_pair
#define pii pair<int,int>
#define F first
#define S second 
#define mod 1000000007
const int  M=1,N=2e5+10;
ll fac[N],ts[N];
list<int> g[N];
bool boss[N];ll ct,aa;

ll modInverse(ll n,ll p) 
{ 
    return power(n, p-2, p); 
} 
 
int nCr(ll n,ll r) 
{ 
   // Base case 
   if (r==0 || r==n || n==0) 
      return 1; 
    ll p=mod;
  
    return (((fac[n]* modInverse(fac[r], p) % p) * 
            modInverse(fac[n-r], p) % p)) % p; 
} 

void dfs(int n)
{
    ts[n]=1;
    fra(g[n]) dfs(x);
    ll sz=0;
    fra(g[n])sz+=ts[x];
    ts[n]+=sz;
    fra(g[n])
    {
        aa=(aa*nCr(sz,ts[x]))%mod;
        sz-=ts[x];
    }
}

int main()
{
    fac[0]=1;
    for(ll i=1;i<N;i++)fac[i]=(i*fac[i-1])%mod;
    int t0;cin>>t0;
    
    while(t0--)
    {
        fr(N)   g[i].clear();
        fr(N)boss[i]=1;
        fr(N)ts[i]=0;
        int n,m,a,b;cin>>n>>m;
        
        fr(m){cin>>a>>b;g[a].PB(b);boss[b]=0;}
        ll ans=1,sz=n;ct=0;
        fr(n)
        {
            ct=0,aa=1;
            
            if(boss[i+1])
            {
                dfs(i+1);ans=(ans*aa)%mod;
                
                ct=ts[i+1];
                ans=(ans*nCr(sz,ct))%mod;
                
                sz-=ct;
            }
        }
        
        cout<<ans<<endl;
    
    
    }
    





}




