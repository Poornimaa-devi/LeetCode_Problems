1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int n = nums.length;
4        if(n==1){
5            return 1;
6        }
7        int min = 0;
8        int max = 0;
9        for(int i=1;i<n;i++){
10            if(nums[i] < nums[min]){
11                min = i;
12            }
13            if(nums[i] > nums[max]){
14                max = i;
15            }
16        }
17        int s1 = Math.max(min,max)+1;
18        
19        int s2 = n - Math.min(min,max);
20        int s3 = 0;
21        if(min > max){
22            s3 = (max+1) + (n-min);
23        }else if(min < max){
24            s3 = (min+1) + (n-max);
25        }
26        int result = Math.min(s1,s2);
27        result = Math.min(result,s3);
28        return result;
29
30        
31
32    }
33}