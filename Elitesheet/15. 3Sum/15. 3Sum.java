1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> result = new ArrayList<>();
4        Arrays.sort(nums);
5        for(int i=0;i<nums.length-2;i++){
6            if(i>0 && nums[i]==nums[i-1]) continue;
7            int left = i+1;
8            int right = nums.length-1;
9            while(left<right){
10                int sum = nums[i]+nums[left]+nums[right];
11                if(sum==0){
12                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
13                    while(left<right && nums[left]==nums[left+1]) left++;
14                    while(left<right && nums[right]==nums[right-1]) right--;
15                    left++;
16                    right--;
17                }else if(sum<0){
18                    left++;
19                }else{
20                    right--;
21                }
22            }
23        }
24        return result;
25    }
26}