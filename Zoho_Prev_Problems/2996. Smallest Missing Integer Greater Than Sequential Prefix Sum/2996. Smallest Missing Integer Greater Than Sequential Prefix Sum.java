1class Solution {
2    public int missingInteger(int[] nums) {
3        int result=0;
4        int commpref=nums.length-1;
5        int sum = nums[0];
6        for(int i=1;i<nums.length;i++){
7            if(nums[i]!=nums[i-1]+1){
8                 commpref=i-1;
9                 break;
10            }else{
11                sum+=nums[i];
12            }
13        }
14        boolean[] array = new boolean[51];
15        for(int i=0;i<nums.length;i++){
16            array[nums[i]]=true;
17        }
18        while(sum<=50 && array[sum]){
19            sum++;
20        }
21        return sum;
22    }
23}