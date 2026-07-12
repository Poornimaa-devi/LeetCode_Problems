1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        
4        int n = nums.length;
5        int[] result = new int[n];
6
7        result[0] = 1;
8
9        // prefix product
10        for(int i = 1; i < n; i++){
11            result[i] = result[i-1] * nums[i-1];
12        }
13
14        int right = 1;
15
16        // suffix product
17        for(int i = n-1; i >= 0; i--){
18            result[i] = result[i] * right;
19            right *= nums[i];
20        }
21
22        return result;
23    }
24}