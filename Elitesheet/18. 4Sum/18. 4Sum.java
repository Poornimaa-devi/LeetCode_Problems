1import java.util.*;
2
3public class Solution {
4    public List<List<Integer>> fourSum(int[] nums, int target) {
5        List<List<Integer>> result = new ArrayList<>();
6        if (nums == null || nums.length < 4) return result;
7        Arrays.sort(nums);
8
9        int n = nums.length;
10        for (int i = 0; i < n - 3; i++) {
11            
12            if (i > 0 && nums[i] == nums[i - 1]) continue;
13
14            for (int j = i + 1; j < n - 2; j++) {
15                
16                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
17
18                int left = j + 1;
19                int right = n - 1;
20
21                while (left < right) {
22                    
23                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
24
25                    if (sum == target) {
26                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
27                        
28                        while (left < right && nums[left] == nums[left + 1]) left++;
29                        while (left < right && nums[right] == nums[right - 1]) right--;
30                        
31                        left++;
32                        right--;
33                    } else if (sum < target) {
34                        left++; 
35                    } else {
36                        right--; 
37                    }
38                }
39            }
40        }
41        return result;
42    }
43}
44
45