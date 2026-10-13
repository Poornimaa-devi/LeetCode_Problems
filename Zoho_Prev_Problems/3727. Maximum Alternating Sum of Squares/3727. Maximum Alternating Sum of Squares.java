1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        int n = nums.length;
4        int maxVal = 0;
5        for(int i = 0; i < n; i++){
6            if(nums[i]<0) nums[i]*=-1;
7            maxVal = Math.max(nums[i], maxVal);
8        }
9        int[] freq = new int[maxVal+1];
10        for(int x : nums) freq[x]++;
11        int l = 0, r = maxVal;
12        long sum = 0;
13        while(r>l ){
14            while(l < r && freq[l] == 0)l++;
15            while(l < r && freq[r] == 0)r--;
16        
17            int cnt = Math.min(freq[l], freq[r]);
18            freq[l]-=cnt;
19            freq[r]-=cnt;
20            long diff = r*r - l*l;
21            sum+=(diff *cnt);
22        }
23        if((freq[r] & 1) != 0){
24            sum += r*r;
25        }
26        else if((freq[l] & 1) != 0){
27            sum += l*l;
28        }
29        return sum;
30    }
31}