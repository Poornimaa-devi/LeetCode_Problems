<h2><a href="https://leetcode.com/problems/linked-list-cycle-ii">142. Linked List Cycle II</a></h2>

<p>Given the <code>head</code> of a linked list, return <em>the node where the cycle begins. If there is no cycle, return </em><code>null</code>.</p>

<p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the <code>next</code> pointer. Internally, <code>pos</code> is used to denote the index of the node that tail's <code>next</code> pointer is connected to (<strong>0-indexed</strong>). It is <code>-1</code> if there is no cycle. <strong>Note that</strong> <code>pos</code> <strong>is not passed as a parameter</strong>.</p>

<p><strong>Do not modify</strong> the linked list.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="height: 145px; width: 450px;">
<pre><strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> tail connects to node index 1
<strong>Explanation:</strong> There is a cycle in the linked list, where tail connects to the second node.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="height: 105px; width: 201px;">
<pre><strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> tail connects to node index 0
<strong>Explanation:</strong> There is a cycle in the linked list, where tail connects to the first node.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="height: 65px; width: 65px;">
<pre><strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> no cycle
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

# 🛍️ Linked-List-Cycle-II | Explained
## Approach 1: Floyd's Tortoise and Hare Algorithm
### Intuition
Imagine you are trying to catch a thief in a circular maze. You have two detectives, one who moves slowly (the tortoise) and one who moves quickly (the hare). If there is a cycle in the maze, the hare will eventually catch up to the tortoise. Once they meet, you can use this information to find the entrance to the cycle. In this case, the slow and fast pointers represent the tortoise and hare, respectively. This approach works because the fast pointer will always catch up to the slow pointer if there is a cycle, due to the properties of modular arithmetic.

### Approach
The algorithm can be broken down into the following steps:
1. Initialize two pointers, slow and fast, to the head of the linked list.
2. Move the slow pointer one step at a time, and the fast pointer two steps at a time.
3. If the fast pointer reaches the end of the linked list, there is no cycle.
4. If the slow and fast pointers meet, there is a cycle.
5. Once a cycle is detected, reset one of the pointers to the head of the list and move both pointers one step at a time. The point where they meet again is the start of the cycle.

### Detailed Code Analysis
Let's dive into the code block:
- The function `detectCycle` takes the head of a linked list as input and returns the node where the cycle starts, or `null` if there is no cycle.
- Lines 4-5 handle the edge case where the input list is empty.
- Lines 6-7 initialize the slow and fast pointers to the head of the list.
- The while loop (lines 10-23) moves the slow and fast pointers based on the Floyd's Tortoise and Hare Algorithm. The loop continues until the fast pointer reaches the end of the list or the slow and fast pointers meet.
- Inside the loop, lines 11-12 move the slow and fast pointers.
- The if statement (lines 15-22) checks if the slow and fast pointers have met. If they have, it means there is a cycle, and the code proceeds to find the start of the cycle.
- Lines 16-20 reset one of the pointers to the head of the list and move both pointers one step at a time until they meet again. This is done to find the start of the cycle.
- The function returns the node where the cycle starts, or `null` if there is no cycle.

### Code
```java
public ListNode detectCycle(ListNode head) {
    if (head == null) return null;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            ListNode entry = head;
            while(entry!=slow){
                entry=entry.next;
                slow=slow.next;
            }
            return entry;
        }
    }

    return null;
}
```
### Complexity
- Time: O(n) where n is the number of nodes in the linked list. In the worst-case scenario, the fast pointer will traverse the entire list.
- Space: O(1) because we only use a constant amount of space to store the slow and fast pointers.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem include:
1. How would you modify the algorithm to detect a cycle in a linked list with a given probability?
 Answer: You could use a probabilistic approach, such as using a hash set to store the nodes and checking for collisions.
2. What are the trade-offs between using Floyd's Tortoise and Hare Algorithm and other cycle detection algorithms?
 Answer: Floyd's algorithm has a time complexity of O(n) and a space complexity of O(1), making it efficient for large lists. However, other algorithms like the hash set approach may have a faster average-case time complexity but require more space.