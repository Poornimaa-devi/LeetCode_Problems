<h2><a href="https://leetcode.com/problems/next-permutation">31. Next Permutation</a></h2>

<p>A <strong>permutation</strong> of an array of integers is an arrangement of its members into a sequence or linear order.</p>

<ul>
	<li>For example, for <code>arr = [1,2,3]</code>, the following are all the permutations of <code>arr</code>: <code>[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]</code>.</li>
</ul>

<p>The <strong>next permutation</strong> of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the <strong>next permutation</strong> of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).</p>

<ul>
	<li>For example, the next permutation of <code>arr = [1,2,3]</code> is <code>[1,3,2]</code>.</li>
	<li>Similarly, the next permutation of <code>arr = [2,3,1]</code> is <code>[3,1,2]</code>.</li>
	<li>While the next permutation of <code>arr = [3,2,1]</code> is <code>[1,2,3]</code> because <code>[3,2,1]</code> does not have a lexicographical larger rearrangement.</li>
</ul>

<p>Given an array of integers <code>nums</code>, <em>find the next permutation of</em> <code>nums</code>.</p>

<p>The replacement must be <strong><a href="http://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a></strong> and use only constant extra memory.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [1,3,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> [1,2,3]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,5]
<strong>Output:</strong> [1,5,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>


---

# 🛍️ Next-Permutation | Explained

## Approach 1 (Optimized)
### Intuition
Imagine you have a set of numbers that can be arranged in a specific order. The goal is to find the next permutation of these numbers. To achieve this, we need to think about how we can "increment" the current permutation to get the next one. One way to do this is by finding the first decreasing digit from the right (i.e., the first digit that is smaller than the one to its right) and swapping it with the smallest digit to its right that is larger than it. Then, we reverse the digits to the right of the swapped digit to get the smallest possible permutation. This approach works because it ensures that the resulting permutation is the smallest possible one that is greater than the original permutation.

### Approach
The algorithm can be broken down into the following steps:
1. Find the first decreasing digit from the right (i.e., `i` in the code).
2. If such a digit is found, find the smallest digit to its right that is larger than it (i.e., `j` in the code).
3. Swap the two digits found in steps 1 and 2.
4. Reverse the digits to the right of the swapped digit.

### Detailed Code Analysis
Let's dive into the code:
- The code initializes `i` to the second last element of the array (`int i = nums.length-2;`). This is because we are looking for the first decreasing digit from the right.
- The code then enters a while loop that continues until it finds a decreasing digit or reaches the beginning of the array (`while(i>=0 && nums[i]>=nums[i+1])`). If no such digit is found, it means that the current permutation is the largest possible one, and there is no next permutation.
- If a decreasing digit is found (`if(i>=0)`), the code initializes `j` to the last element of the array (`int j = nums.length-1;`) and enters another while loop. This loop continues until it finds the smallest digit to the right of `i` that is larger than `nums[i]` (`while (nums[j] <= nums[i])`).
- Once `j` is found, the code swaps `nums[i]` and `nums[j]` using a temporary variable (`int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;`).
- After swapping, the code reverses the digits to the right of `i` using two pointers (`int left = i+1; int right = nums.length-1;`) and a while loop (`while(left<right)`).
- Inside the loop, the code swaps `nums[left]` and `nums[right]` using a temporary variable (`int temp = nums[left]; nums[left] = nums[right]; nums[right] = temp;`) and then increments `left` and decrements `right` until they meet in the middle.

### Code
```java
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length-1;
            while (nums[j] <= nums[i]) {
              j--;
            }
        
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int left = i+1;
        int right = nums.length-1;
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the length of the input array. This is because in the worst case, we are potentially scanning the entire array twice: once to find the decreasing digit and once to reverse the digits to its right.
- Space: The space complexity is O(1), as we are not using any additional data structures that scale with the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem include:
1. What if the input array contains duplicate elements? How would you modify the solution to handle this case?
   - In this case, the solution would still work correctly, as it only relies on the relative order of the elements, not their actual values.
2. Can you implement a solution that generates all permutations of the input array in lexicographic order?
   - Yes, you can use a backtracking approach to generate all permutations of the input array in lexicographic order. However, this would have a time complexity of O(n!), which is much slower than the O(n) solution for the next-permutation problem.