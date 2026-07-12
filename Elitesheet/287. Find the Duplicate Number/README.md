<h2><a href="https://leetcode.com/problems/find-the-duplicate-number">287. Find the Duplicate Number</a></h2>

<p>Given an array of integers <code>nums</code> containing&nbsp;<code>n + 1</code> integers where each integer is in the range <code>[1, n]</code> inclusive.</p>

<p>There is only <strong>one repeated number</strong> in <code>nums</code>, return <em>this&nbsp;repeated&nbsp;number</em>.</p>

<p>You must solve the problem <strong>without</strong> modifying the array <code>nums</code>&nbsp;and using only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,4,2,2]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,1,3,4,2]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,3,3,3,3]
<strong>Output:</strong> 3</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>nums.length == n + 1</code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
	<li>All the integers in <code>nums</code> appear only <strong>once</strong> except for <strong>precisely one integer</strong> which appears <strong>two or more</strong> times.</li>
</ul>

<p>&nbsp;</p>
<p><b>Follow up:</b></p>

<ul>
	<li>How can we prove that at least one duplicate number must exist in <code>nums</code>?</li>
	<li>Can you solve the problem in linear runtime complexity?</li>
</ul>


---

# 🛍️ Find-the-Duplicate-Number | Explained

## Approach 1: Floyd's Tortoise and Hare Algorithm
### Intuition
The core idea of this approach is to treat the given array as a linked list where each element is a node, and its value is the index of the next node. The duplicate number in the array represents a cycle in this linked list. This approach works by using two pointers, a slow pointer and a fast pointer, to detect the cycle. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a cycle, these two pointers will eventually meet at some point within the cycle. This is similar to how a tortoise and a hare would run around a track - the hare will eventually catch up to the tortoise if the track is circular.

### Approach
The algorithm can be broken down into two phases:
1. Detecting the cycle: The slow and fast pointers are initialized to the first element of the array. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a cycle, these two pointers will eventually meet at some point within the cycle.
2. Finding the start of the cycle: Once the cycle is detected, the slow pointer is reset to the first element of the array, and both pointers move one step at a time. The point where they meet again is the start of the cycle, which corresponds to the duplicate number in the array.

### Detailed Code Analysis
Let's take a closer look at the provided code:
```java
int slow = nums[0];
int fast = nums[0];
```
Here, we initialize the slow and fast pointers to the first element of the array (`nums[0]`). Note that we are not directly using the index `0`, but rather the value at index `0`, which is the first element in our linked list analogy.

The `while (true)` loop is used to detect the cycle:
```java
while (true) {
    slow = nums[slow];
    fast = nums[nums[fast]];
    if (slow == fast) {
        break;
    }
}
```
In each iteration, the slow pointer moves one step to the next element (`slow = nums[slow]`), and the fast pointer moves two steps to the next element (`fast = nums[nums[fast]]`). If the slow and fast pointers meet (`slow == fast`), we break out of the loop, indicating that we have detected the cycle.

Once the cycle is detected, we reset the slow pointer to the first element and move both pointers one step at a time:
```java
int slow2 = nums[0];
while (slow != slow2) {
    slow = nums[slow];
    slow2 = nums[slow2];
}
```
The point where the two pointers meet again is the start of the cycle, which is the duplicate number in the array. This is returned by the `return slow` statement.

### Code
```java
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}
```

### Complexity
- Time: The time complexity of this algorithm is O(n), where n is the number of elements in the array. This is because in the worst case, we might have to traverse the entire array to detect the cycle, and then traverse the cycle again to find the start of the cycle.
- Space: The space complexity is O(1), which means the space required does not change with the size of the input array. This is because we only use a constant amount of space to store the slow and fast pointers.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem include:
- How does the algorithm handle edge cases, such as an empty array or an array with no duplicates?
- Can you optimize the algorithm to find the duplicate number in a single pass?
Answers to these questions may involve modifying the algorithm to include additional error checking or using a different approach, such as a hash table or a sorting-based approach.