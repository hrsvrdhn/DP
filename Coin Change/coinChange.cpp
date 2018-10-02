#include <iostream>
#include <vector>
using namespace std;
#define vi vector<int>
void printSolution(vi track, vi coins) {
	int ind = int(track.size()) - 1;
	while(ind > 0) {
		cout << coins[track[ind]] << " ";
		ind -= coins[track[ind]];
	}
	cout << endl;
}

void coinChangeDP(vi coins, int target) {
	vi dp(target+1, 1<<30);
	vi track(target+1);
	dp[0] = 0;

	for(int i=0; i<int(coins.size()); i++) {
		for(int j=coins[i]; j<=target; j++) {
			if(dp[j] > dp[j-coins[i]] + 1) {
				dp[j] = dp[j-coins[i]] + 1;
				track[j] = i;
			}
		}
	}
	if(dp[target] >= (1<<30))
		cout << "Not possible.";
	else {
		cout << "Min coins required = " << dp[target] << "\n Coins = ";
		printSolution(track, coins);
	}
}
int main() {
	vi coins = {3, 2, 4, 6};
	int target = 19;
	coinChangeDP(coins, target);
}