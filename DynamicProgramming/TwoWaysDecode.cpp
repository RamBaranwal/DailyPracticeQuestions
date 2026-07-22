#include <iostream>
#include <string>
#include <vector>
using namespace std;

int numDecodingWays(string s){
    if(s.empty() || s[0] == '0'){
        return 0;
    }

    int n = s.length();
    vector<int> dp(n + 1, 0);

    //Init
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
        // Single Digit
        int oneDigit = s[i - 1] - '0';
        if(oneDigit >= 1 && oneDigit <= 9){
            dp[i] = dp[i] + dp[i - 1];
        }

        // Two Digit
        int twoDigit = stoi(s.substr(i - 2, 2));
        if(twoDigit >= 10 && twoDigit <= 26){
            dp[i] = dp[i] + dp[i - 2];
        }
    }

    return dp[n];
}

int main(){
    cout << "Enter the value: "<< endl;

    string s;
    cin >> s;
    cout << numDecodingWays(s) << endl;
}