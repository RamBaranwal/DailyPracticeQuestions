#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int minJump(vector<int> &nums){
    int jumps = 0;
    int curretReach = 0;
    int maxReach = 0;
    for(int i = 0; i < nums.size() - 1; i++){
        maxReach = max(maxReach, nums[i] + i);
        if(i == curretReach){
            jumps++;
            curretReach = maxReach;
        }
    }
    return jumps;
}

int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    cout << minJump(nums) << endl;
}