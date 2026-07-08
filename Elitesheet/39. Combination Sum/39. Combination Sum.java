1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> result = new ArrayList<>();
4        backtrack(new ArrayList<>(),result,candidates,target,0);
5        return result;
6    }
7    public static void backtrack(List<Integer> list1,List<List<Integer>> result,int[] nums,int target,int idx){
8        if(target==0){
9            result.add(new ArrayList<>(list1));
10            return;
11        }
12        if(target<0){
13            return;
14        }
15        for(int i=idx;i<nums.length;i++){
16            list1.add(nums[i]);
17            backtrack(list1,result,nums,target-nums[i],i);
18            list1.remove(list1.size()-1);
19        }
20    }
21}