<h2><a href="https://leetcode.com/problems/3sum">15. 3Sum</a></h2>

<p>Given an integer array nums, return all the triplets <code>[nums[i], nums[j], nums[k]]</code> such that <code>i != j</code>, <code>i != k</code>, and <code>j != k</code>, and <code>nums[i] + nums[j] + nums[k] == 0</code>.</p>

<p>Notice that the solution set must not contain duplicate triplets.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-1,0,1,2,-1,-4]
<strong>Output:</strong> [[-1,-1,2],[-1,0,1]]
<strong>Explanation:</strong> 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,1]
<strong>Output:</strong> []
<strong>Explanation:</strong> The only possible triplet does not sum up to 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [0,0,0]
<strong>Output:</strong> [[0,0,0]]
<strong>Explanation:</strong> The only possible triplet sums up to 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


---

# 🛍️ 3Sum | Explained

## Approach 1 (Optimized Two-Pointer Technique)
### Intuition
Imagine you have a list of numbers, and you want to find all unique triplets that sum up to zero. A naive approach would be to check all possible combinations of three numbers, but this would be very inefficient. The optimized approach used in the provided code is to sort the list first and then use a two-pointer technique. The intuition behind this approach is to fix one number and then use the two pointers to find a pair of numbers that sum up to the negation of the fixed number. This approach works because the list is sorted, allowing us to easily skip duplicate triplets and efficiently find the desired pairs.

### Approach
The approach can be broken down into the following steps:
1. Sort the input list.
2. Iterate over the list, fixing one number at a time.
3. Use a two-pointer technique to find a pair of numbers that sum up to the negation of the fixed number.
4. If a pair is found, add the triplet to the result list and skip any duplicate triplets.

### Detailed Code Analysis
Let's dive into the code block:
```java
List<List<Integer>> result = new ArrayList<>(); // Initialize an empty list to store the result
Arrays.sort(nums); // Sort the input list
for (int i = 0; i < nums.length - 2; i++) { // Iterate over the list, fixing one number at a time
    if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate triplets
    int left = i + 1; // Initialize the left pointer
    int right = nums.length - 1; // Initialize the right pointer
    while (left < right) { // Use the two-pointer technique
        int sum = nums[i] + nums[left] + nums[right]; // Calculate the sum of the current triplet
        if (sum == 0) { // If the sum is zero, add the triplet to the result list
            result.add(Arrays.asList(nums[i], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicate triplets
            while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicate triplets
            left++; // Move the left pointer
            right--; // Move the right pointer
        } else if (sum < 0) { // If the sum is less than zero, move the left pointer
            left++;
        } else { // If the sum is greater than zero, move the right pointer
            right--;
        }
    }
}
```
The code uses an `ArrayList` to store the result, which is a dynamic array-based implementation of the `List` interface. The input list is sorted using the `Arrays.sort()` method. The outer loop iterates over the list, fixing one number at a time. The inner while loop uses the two-pointer technique to find a pair of numbers that sum up to the negation of the fixed number.

### Code
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(n^2), where n is the length of the input list. This is because we have a nested loop structure, with the outer loop iterating over the list and the inner while loop using the two-pointer technique. The sorting step at the beginning takes O(n log n) time, but this is dominated by the O(n^2) complexity of the nested loop structure.
- Space: The space complexity of this approach is O(n), where n is the length of the input list. This is because we use an `ArrayList` to store the result, which can potentially store up to n/3 triplets (since each triplet has three numbers).

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
1. How would you optimize the solution to handle duplicate triplets?
   * The provided code already handles duplicate triplets by skipping them in the outer loop and the inner while loop.
2. What if the input list is not sorted?
   * If the input list is not sorted, we can sort it at the beginning of the solution, which takes O(n log n) time. Alternatively, we can use a different approach that does not require sorting, such as using a hash map to store the numbers and their indices. However, this approach would likely have a higher time complexity.