1class Solution {
2    public int findDuplicate(int[] nums) {
3        int slow = nums[0];
4        int fast = nums[0];
5        while(true){
6            slow=nums[slow];
7            fast = nums[nums[fast]];
8
9            if(slow==fast){
10                break;
11            }
12        }
13
14        int slow2=nums[0];
15        while(slow!=slow2){
16            slow=nums[slow];
17            slow2=nums[slow2];
18        }
19        return slow;
20    }
21}