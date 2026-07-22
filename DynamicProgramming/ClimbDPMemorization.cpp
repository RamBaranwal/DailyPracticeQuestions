#include <iostream>
#include <vector>
using namespace std;

int climb(int n, vector<int> &dp) {
    if (n == 0 || n == 1) {
        return 1;
    }

    if (dp[n] != -1) {
        return dp[n];
    }

    dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
    return dp[n];
}

int main() {
    int n;
    cout << "Enter number of stairs: ";
    cin >> n;

    vector<int> dp(n + 1, -1);

    cout << "Number of ways = " << climb(n, dp) << endl;

    return 0;
}

// edit distance
// stickler thief
// word break

// lcs
// lps
// top - bottom  memorization + recursion
// bottoms up -> decrease space complexity store the pre defined values into the dp use it afterword

