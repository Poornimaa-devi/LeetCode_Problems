<h2><a href="https://leetcode.com/problems/middle-of-the-linked-list">876. Middle of the Linked List</a></h2>

<p>Given the <code>head</code> of a singly linked list, return <em>the middle node of the linked list</em>.</p>

<p>If there are two middle nodes, return <strong>the second middle</strong> node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [3,4,5]
<strong>Explanation:</strong> The middle node of the list is node 3.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5,6]
<strong>Output:</strong> [4,5,6]
<strong>Explanation:</strong> Since the list has two middle nodes with values 3 and 4, we return the second one.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 100]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
</ul>


---

# 🛍️ Middle-of-the-Linked-List | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to utilize the concept of two pointers, a slow pointer and a fast pointer, both starting at the beginning of the linked list. The fast pointer moves twice as fast as the slow pointer, so when the fast pointer reaches the end of the list, the slow pointer will be at the middle of the list. This approach works because it takes advantage of the fact that the fast pointer will always be twice as far ahead of the slow pointer, allowing us to find the middle node in a single pass through the list.

### Approach
Here is the step-by-step breakdown of the algorithm:

1. Initialize two pointers, `slow` and `fast`, to the head of the linked list.
2. Enter a loop where `fast` and `fast.next` are not null.
3. Inside the loop, move the `slow` pointer one step forward and the `fast` pointer two steps forward.
4. When the loop ends, the `slow` pointer will be at the middle of the linked list.
5. Return the node at the `slow` pointer.

### Detailed Code Analysis
The given code can be broken down as follows:
- Lines 13-14: We initialize two pointers, `slow` and `fast`, to the head of the linked list. This is where we start our traversal.
- Line 15: We enter a while loop that continues as long as `fast` and `fast.next` are not null. This condition ensures that `fast` can move two steps forward without going out of bounds.
- Lines 16-17: Inside the loop, we move `slow` one step forward and `fast` two steps forward. This is the key to the algorithm, as it maintains the relationship between `slow` and `fast`.
- Line 19: After the loop ends, we return the node at the `slow` pointer, which is now at the middle of the linked list.

### Code
```java
ListNode slow = head;
ListNode fast = head;
while(fast!=null && fast.next !=null){
    slow = slow.next;
    fast = fast.next.next;
}
return slow;
```

### Complexity
- Time: The time complexity is O(n), where n is the number of nodes in the linked list. This is because we are traversing the list once, and the while loop runs for n/2 iterations in the worst case.
- Space: The space complexity is O(1), as we are only using a constant amount of space to store the `slow` and `fast` pointers, regardless of the size of the input linked list.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
- How would you handle an empty linked list? 
  - In this implementation, if the input linked list is empty (i.e., `head` is null), the method will simply return null.
- What if the linked list has an even number of nodes? 
  - In this case, the method will return the second middle node. If you want to return the first middle node, you can modify the loop condition to `fast.next.next != null`.