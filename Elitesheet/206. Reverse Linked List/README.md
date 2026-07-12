<h2><a href="https://leetcode.com/problems/reverse-linked-list">206. Reverse Linked List</a></h2>

<p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [5,4,3,2,1]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2]
<strong>Output:</strong> [2,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li>
	<li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>


---

# 🛍️ Reverse-Linked-List | Explained

## Approach 1 (Iterative)
### Intuition
The core idea behind this approach is to reverse the linked list by changing the `next` pointer of each node to point to the previous node. This can be visualized as a process of "unraveling" the linked list, where each node is reconnected to the previous one, effectively reversing the order of the list. To understand this intuitively, imagine a string of pearls, where each pearl represents a node in the list. By changing the direction of each pearl's connection to the next one, we effectively turn the string around.

### Approach
The algorithmic process can be broken down into the following high-level steps:
1. Initialize three pointers: `prev`, `curr`, and `next`, where `prev` is the previous node, `curr` is the current node, and `next` is the next node in the original list.
2. Traverse the list starting from the head node.
3. For each node, do the following:
   - Store the next node in the `next` pointer.
   - Reverse the `next` pointer of the current node to point to the previous node.
   - Move the `prev` and `curr` pointers one step forward.
4. Once the end of the list is reached, `prev` will point to the new head of the reversed list.

### Detailed Code Analysis
Let's dive into the provided code block:
```java
ListNode prev = null;
ListNode curr = head;
```
Here, `prev` is initialized to `null`, indicating that there is no previous node at the start of the reversal process. `curr` is set to `head`, which is the starting point of the traversal.
```java
while(curr != null){
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
```
Inside the loop, we first store the next node in the `next` pointer to avoid losing it once we reverse the `next` pointer of the current node. Then, we reverse the `next` pointer of `curr` to point to `prev`, effectively changing the direction of the connection. After that, we move both `prev` and `curr` one step forward by updating `prev` to the current node and `curr` to the next node stored in the `next` pointer.
```java
return prev;
```
Once the loop ends (i.e., when `curr` becomes `null`), `prev` points to the new head of the reversed list, which is then returned.

### Code
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

### Complexity
- Time: **O(n)**, where n is the number of nodes in the list. This is because we traverse the list once.
- Space: **O(1)**, as we only use a constant amount of space to store the `prev`, `curr`, and `next` pointers, regardless of the size of the input list.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you optimize the solution if the linked list is very large?**
   - The current iterative solution already has a linear time complexity and constant space complexity, making it efficient for large lists. However, if the list is extremely large and doesn't fit into memory, a more complex approach involving disk storage and processing the list in chunks might be necessary.
2. **Can you implement a recursive solution for reversing a linked list?**
   - Yes, a recursive solution involves calling a function within itself to reverse the list, where each recursive call moves one step forward in the list until it reaches the end, and then reverses the connections as it unwinds back to the beginning. However, recursive solutions typically have a higher risk of stack overflow for very large lists compared to iterative solutions.