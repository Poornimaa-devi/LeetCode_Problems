<h2><a href="https://leetcode.com/problems/merge-two-sorted-lists">21. Merge Two Sorted Lists</a></h2>

<p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists into one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;">
<pre><strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>


---

# 🛍️ Merge-Two-Sorted-Lists | Explained
The provided code solution for the LeetCode problem "Merge-Two-Sorted-Lists" implements a single approach to merge two sorted lists into one sorted list. 

## Approach 1 (Iterative Two-Pointer Technique)
### Intuition
The core idea behind this approach is to use two pointers to traverse the two sorted lists simultaneously. It works by comparing the current elements of both lists and adding the smaller one to the result list. This process continues until one of the lists is exhausted, at which point the remaining elements from the other list are appended to the result. The intuition can be thought of like merging two stacks of cards, where you pick the smaller card from the top of each stack and place it on top of a new stack, repeating the process until both stacks are empty.

### Approach
The algorithmic steps can be broken down into the following:
1. Create a dummy node for the result list.
2. Initialize two pointers, one for each list, to the head of each list.
3. Compare the values of the nodes at the current positions of the two pointers.
4. Add the node with the smaller value to the result list and move the corresponding pointer forward.
5. Repeat steps 3-4 until one of the lists is exhausted.
6. Append the remaining nodes from the non-exhausted list to the result list.

### Detailed Code Analysis
Let's dive into the code block:
- Lines 11-12 define the `Solution` class with the `mergeTwoLists` function that takes two `ListNode` objects, `list1` and `list2`, as arguments.
- Line 13 creates a dummy node `dummy` with a value of 0. This node serves as a starting point for the result list and simplifies some corner cases such as a list with only one node.
- Line 14 initializes a `current` pointer to the `dummy` node. This pointer will be used to traverse the result list.
- The `while` loop on line 15 continues as long as both `list1` and `list2` are not null. Inside the loop:
  - Lines 16-22 compare the values of the nodes at the current positions of `list1` and `list2`. If the value in `list1` is smaller, it appends `list1` to the result list and moves the `list1` pointer forward. Otherwise, it appends `list2` to the result list and moves the `list2` pointer forward.
  - Line 23 moves the `current` pointer forward to the newly appended node.
- After the `while` loop, lines 25-29 check if either `list1` or `list2` is not null and appends the remaining nodes to the result list.
- Finally, line 31 returns `dummy.next`, which is the head of the merged list (excluding the dummy node).

### Code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(list1 !=null && list2 !=null){
             if(list1.val <= list2.val){
                current.next = list1;
                list1=list1.next;
             }else{
                current.next=list2;
                list2 = list2.next;
             }
             current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        }else{
            current.next = list2;
        }

        return dummy.next;
    }
}
```

### Complexity
- Time: The time complexity of this approach is **O(m + n)**, where **m** and **n** are the lengths of the two input lists. This is because each node is visited once during the merging process.
- Space: The space complexity is **O(m + n)** as well, since in the worst case, the result list will contain all nodes from both input lists. However, if we exclude the space needed for the output, the space complexity is **O(1)** because we only use a constant amount of space to store the dummy node and pointers.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem could be:
1. How would you solve this problem recursively?
   - Answer: You would use a recursive function that compares the current nodes of the two lists and returns the smaller one, recursively calling itself with the next nodes in the lists.
2. What if the input lists are not sorted, how would you modify your solution to handle this case?
   - Answer: You would need to sort the input lists first before merging them. This could be done using a sorting algorithm such as quicksort or mergesort, and then applying the same merging technique as before.