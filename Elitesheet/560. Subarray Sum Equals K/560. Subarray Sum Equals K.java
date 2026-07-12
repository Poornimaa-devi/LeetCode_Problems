1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int sum = 0;
4        int ans = 0;
5        HashMap<Integer,Integer> map = new HashMap<>();
6        map.put(0,1);
7        for(int j=0;j<nums.length;j++){
8            sum += nums[j];
9            if(map.containsKey(sum -k)){
10                ans += map.get(sum-k);
11            }
12            map.put(sum,map.getOrDefault(sum,0)+1);
13        }
14        return ans;
15    }
16}