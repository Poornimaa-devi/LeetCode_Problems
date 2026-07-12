<h2><a href="https://leetcode.com/problems/reverse-linked-list-ii">92. Reverse Linked List II</a></h2>

<p>Given the <code>head</code> of a singly linked list and two integers <code>left</code> and <code>right</code> where <code>left &lt;= right</code>, reverse the nodes of the list from position <code>left</code> to position <code>right</code>, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4
<strong>Output:</strong> [1,4,3,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [5], left = 1, right = 1
<strong>Output:</strong> [5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>n</code>.</li>
	<li><code>1 &lt;= n &lt;= 500</code></li>
	<li><code>-500 &lt;= Node.val &lt;= 500</code></li>
	<li><code>1 &lt;= left &lt;= right &lt;= n</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in one pass?

---

# 🛍️ Reverse-Linked-List-II | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to treat the linked list as a sequence of nodes that need to be rearranged within a specified range (from `left` to `right` index). This can be thought of as a "sub-list" within the larger list that needs to be reversed. The intuition here is to first identify the "sub-list" to be reversed and then reverse the links within this sub-list, while keeping the rest of the list intact. This approach works by essentially creating a temporary "dummy" node to simplify the handling of edge cases (like when the list starts with the node to be reversed), and then carefully manipulating the `next` pointers of the nodes within the sub-list to achieve the reversal.

### Approach
The high-level logic flow of this approach involves:
1. Creating a "dummy" node to simplify edge case handling.
2. Finding the node before the sub-list to be reversed (`leftPre`).
3. Identifying the start of the sub-list to be reversed (`currNode`).
4. Reversing the sub-list by manipulating the `next` pointers.
5. Connecting the reversed sub-list back to the rest of the original list.

### Detailed Code Analysis
Let's break down the code line by line:
- Lines 11-14: A `dummy` node is created, and its `next` pointer is set to the `head` of the list. This dummy node is used to handle edge cases.
- Lines 15-16: `leftPre` is initialized to the `dummy` node, and `currNode` is set to the `head`. These variables will be used to find the sub-list to be reversed.
- Lines 17-20: A loop is used to move `leftPre` and `currNode` to the correct positions based on the `left` index. `leftPre` is the node before the sub-list, and `currNode` is the start of the sub-list.
- Lines 21-28: The sub-list is reversed by changing the `next` pointers of its nodes. Specifically:
  - `preNode` is initialized to `null`, which will keep track of the previous node in the reversed sub-list.
  - `subListHead` is set to `currNode`, marking the start of the sub-list before reversal.
  - The loop iterates `right - left + 1` times, which is the length of the sub-list to be reversed. In each iteration, the `next` pointer of `currNode` is set to `preNode`, effectively reversing the link.
  - `preNode` and `currNode` are updated for the next iteration.
- Lines 29-30: After the sub-list is reversed, `leftPre.next` is set to the new head of the reversed sub-list (`preNode`), and `subListHead.next` is set to the remaining part of the original list (`currNode`), effectively connecting the reversed sub-list back to the rest of the list.
- Line 32: The function returns `dummy.next`, which is the head of the modified list.

### Code
```java
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode leftPre = dummy;
ListNode currNode = head;
for(int i = 0;i < left-1;i++){
    leftPre = leftPre.next;
    currNode = currNode.next;
}
ListNode preNode = null;
ListNode subListHead = currNode;
for(int i = 0;i <= right-left;i++){
    ListNode nextNode = currNode.next;
    currNode.next = preNode;
    preNode = currNode;
    currNode = nextNode;
}
leftPre.next = preNode;
subListHead.next = currNode;
return dummy.next;
```

### Complexity
- Time: The time complexity is O(L), where L is the length of the linked list, because in the worst case, we traverse the entire list once to find the sub-list and then reverse it. However, more precisely, we can break it down into two parts: finding the sub-list (O(left)) and reversing the sub-list (O(right - left + 1)). Since the second for loop's iterations are bounded by the length of the sub-list and do not exceed the length of the entire list, the overall time complexity remains linear with respect to the length of the list.
- Space: The space complexity is O(1), as we only use a constant amount of space to store the dummy node and other variables, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle edge cases where `left` equals 1 or `right` equals the length of the list?**
   - The current implementation already handles these cases correctly by using the dummy node. When `left` is 1, `leftPre` will be the dummy node, simplifying the connection of the reversed sub-list to the rest of the list.
2. **Can you optimize the solution further for very large lists?**
   - The solution is already optimized for large lists with a linear time complexity. However, in terms of practical optimization, ensuring that the input indices `left` and `right` are validated (e.g., checking if they are within the bounds of the list) could prevent potential errors and improve robustness.