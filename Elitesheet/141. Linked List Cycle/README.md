<h2><a href="https://leetcode.com/problems/linked-list-cycle">141. Linked List Cycle</a></h2>

<p>Given <code>head</code>, the head of a linked list, determine if the linked list has a cycle in it.</p>

<p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the&nbsp;<code>next</code>&nbsp;pointer. Internally, <code>pos</code>&nbsp;is used to denote the index of the node that&nbsp;tail's&nbsp;<code>next</code>&nbsp;pointer is connected to.&nbsp;<strong>Note that&nbsp;<code>pos</code>&nbsp;is not passed as a parameter</strong>.</p>

<p>Return&nbsp;<code>true</code><em> if there is a cycle in the linked list</em>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="width: 300px; height: 97px; margin-top: 8px; margin-bottom: 8px;">
<pre><strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="width: 141px; height: 74px;">
<pre><strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 0th node.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="width: 45px; height: 45px;">
<pre><strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no cycle in the linked list.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the nodes in the list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li><code>pos</code> is <code>-1</code> or a <strong>valid index</strong> in the linked-list.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you solve it using <code>O(1)</code> (i.e. constant) memory?</p>


---

# 🛍️ Linked-List-Cycle | Explained

## Approach 1 (Floyd's Tortoise and Hare Algorithm)
### Intuition
The intuition behind this approach is to use two pointers, a slow pointer and a fast pointer, to traverse the linked list. The fast pointer moves twice as fast as the slow pointer. If there is a cycle in the linked list, the fast pointer will eventually catch up to the slow pointer. This is similar to a real-world scenario where a tortoise and a hare are racing. If the hare is moving twice as fast as the tortoise, but they are running in a circular track, the hare will eventually catch up to the tortoise.

### Approach
The algorithmic breakdown is as follows:
1. Initialize two pointers, slow and fast, to the head of the linked list.
2. Traverse the linked list using a while loop.
3. In each iteration, move the slow pointer one step forward and the fast pointer two steps forward.
4. Check if the fast pointer has caught up to the slow pointer. If it has, return true, indicating that there is a cycle in the linked list.
5. If the loop completes without finding a cycle, return false, indicating that there is no cycle in the linked list.

### Detailed Code Analysis
Let's break down the code:
- `ListNode slow = head;` and `ListNode fast = head;` initialize the slow and fast pointers to the head of the linked list.
- `while(fast != null && fast.next != null)` is the loop condition. It checks if the fast pointer and its next node are not null, ensuring that we can safely move the fast pointer two steps forward.
- `slow = slow.next;` moves the slow pointer one step forward.
- `fast = fast.next.next;` moves the fast pointer two steps forward.
- `if(slow == fast)` checks if the fast pointer has caught up to the slow pointer. If it has, the method returns true, indicating that there is a cycle in the linked list.
- `return false;` is executed if the loop completes without finding a cycle.

### Code
```java
ListNode slow = head;
ListNode fast = head;

while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
    
    if(slow == fast){
        return true;
    }
}

return false;
```

### Complexity
- Time: The time complexity of this approach is O(n), where n is the number of nodes in the linked list. This is because in the worst-case scenario, the slow pointer will visit each node once.
- Space: The space complexity of this approach is O(1), which means it uses constant space. This is because we only use a fixed amount of space to store the slow and fast pointers, regardless of the size of the linked list.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
- Can you explain how to find the start of the cycle?
  Answer: To find the start of the cycle, we can use a two-step approach. First, we use the Floyd's Tortoise and Hare algorithm to detect the cycle. Once we detect the cycle, we move one of the pointers (e.g., the slow pointer) back to the head of the linked list, while keeping the other pointer (e.g., the fast pointer) at the meeting point. Then, we move both pointers one step at a time. The point where they meet again is the start of the cycle.
- Can you explain how to handle the case where the linked list is empty?
  Answer: To handle the case where the linked list is empty, we can simply check if the head of the linked list is null before entering the loop. If it is null, we can immediately return false, indicating that there is no cycle in the linked list.