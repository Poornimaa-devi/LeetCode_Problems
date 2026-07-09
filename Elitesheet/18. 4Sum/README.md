<h2><a href="https://leetcode.com/problems/4sum">18. 4Sum</a></h2>

<p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>

<ul>
	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
</ul>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
<strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,2,2,2,2], target = 8
<strong>Output:</strong> [[2,2,2,2]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ 4Sum | Explained

The provided code solution is for the LeetCode problem "4Sum". This problem asks to find all quadruplets in the given array that sum up to the target value.

## Approach 1 (e.g., Optimized)
### Intuition
The core idea behind this approach is to use a two-pointer technique to find the quadruplets. Imagine you have a list of numbers, and you want to find all possible combinations of four numbers that add up to a certain target value. You can start by fixing the first two numbers and then use two pointers, one starting from the next number and one from the end, to find the remaining two numbers that add up to the target value minus the sum of the first two numbers. This approach works because it allows us to efficiently search for the remaining two numbers in a sorted array.

### Approach
The algorithm can be broken down into the following steps:

1. Sort the input array in ascending order.
2. Fix the first number and iterate over the array.
3. Fix the second number and iterate over the remaining array.
4. Use two pointers, one starting from the next number and one from the end, to find the remaining two numbers that add up to the target value minus the sum of the first two numbers.
5. If the sum of the four numbers is equal to the target value, add the quadruplet to the result list and move the pointers.
6. If the sum is less than the target value, move the left pointer to increase the sum.
7. If the sum is greater than the target value, move the right pointer to decrease the sum.

### Detailed Code Analysis
Let's take a closer look at the code:

- The code starts by checking if the input array is null or has less than 4 elements. If so, it returns an empty list.
- The array is then sorted in ascending order using the `Arrays.sort()` method.
- The outer two loops iterate over the array to fix the first two numbers. The `if` conditions inside these loops skip duplicate numbers to avoid duplicate quadruplets in the result list.
- The two pointers, `left` and `right`, are initialized to the next number and the end of the array, respectively.
- The `while` loop moves the pointers based on the sum of the four numbers. If the sum is equal to the target value, the quadruplet is added to the result list, and the pointers are moved. If the sum is less than the target value, the left pointer is moved to increase the sum. If the sum is greater than the target value, the right pointer is moved to decrease the sum.
- The `long` data type is used to calculate the sum to avoid overflow.

### Code
```java
import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; 
                    } else {
                        right--; 
                    }
                }
            }
        }
        return result;
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(n^3), where n is the length of the input array. This is because we have three nested loops: the outer two loops iterate over the array to fix the first two numbers, and the inner while loop moves the pointers.
- Space: The space complexity is O(n), as we need to store the result list.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:

- How would you handle duplicate quadruplets in the result list?
- What if the input array is very large, and we need to optimize the space complexity?
- Can we use a different approach, such as using a hash table to store the numbers and their indices? 

Brief answers:

- To handle duplicate quadruplets, we can skip duplicate numbers in the outer two loops, as shown in the provided code.
- To optimize the space complexity, we can use a different approach, such as using a hash table to store the numbers and their indices, which would reduce the space complexity to O(1).
- Yes, we can use a different approach, such as using a hash table to store the numbers and their indices. However, this approach would have a different time complexity, and it may not be more efficient than the provided approach.