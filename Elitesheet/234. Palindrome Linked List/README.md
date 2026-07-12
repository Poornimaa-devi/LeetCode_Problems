<h2><a href="https://leetcode.com/problems/palindrome-linked-list">234. Palindrome Linked List</a></h2>

<p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class=""><em>palindrome</em></button></span><em> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;">
<pre><strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;">
<pre><strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?

---

# 🛍️ Palindrome-Linked-List | Explained

## Approach 1 (Two-Pointer, Fast and Slow)
### Intuition
Imagine you have a long stick with equal lengths of string attached to both ends. If you wanted to check if the stick is the same length on both sides of a midpoint, you could use two pointers, one moving twice as fast as the other, to find the center. Then, you could reverse one half of the string and compare it to the other half to check if they are the same. This approach works for linked lists because it allows us to find the midpoint, reverse the second half, and then compare the two halves in a single pass.

### Approach
1. Initialize two pointers, a fast and slow pointer, to the head of the list.
2. Move the fast pointer twice as fast as the slow pointer until the fast pointer reaches the end of the list. The slow pointer will be at the midpoint.
3. Reverse the second half of the list.
4. Compare the first half and the reversed second half.

### Detailed Code Analysis
Let's break down the provided code:
- We start with two pointers, `slow` and `fast`, both at the head of the list (`head`). This allows us to begin the process of finding the midpoint of the linked list.
- The while loop (`while(fast!=null && fast.next!=null)`) continues until the `fast` pointer reaches the end of the list. Inside this loop, we move the `slow` pointer one step at a time (`slow = slow.next;`) and the `fast` pointer two steps at a time (`fast = fast.next.next;`). This effectively makes the `fast` pointer move twice as fast as the `slow` pointer.
- Once the `fast` pointer reaches the end, the `slow` pointer is at the midpoint of the list.
- We then initialize a `prev` pointer to `null` and start reversing the second half of the list. This is done by iterating through the nodes starting from the `slow` pointer and reversing the `next` pointers. The lines `ListNode next = slow.next;`, `slow.next = prev;`, `prev = slow;`, and `slow = next;` essentially reverse the link of each node.
- After reversing the second half, we initialize two pointers, `first` and `second`, to the beginning of the list and the reversed second half, respectively.
- We then compare the values of the nodes at the `first` and `second` pointers. If any pair of nodes has different values, the function immediately returns `false`, indicating the list is not a palindrome.
- If the loop completes without finding any mismatched pairs, the function returns `true`, indicating that the list is a palindrome.

### Code
```java
ListNode slow = head;
ListNode fast = head;
while(fast!=null && fast.next!=null){
    slow = slow.next;
    fast = fast.next.next;
}
ListNode prev = null;
while(slow!=null){
    ListNode next = slow.next;
    slow.next = prev;
    prev = slow;
    slow = next;
}
ListNode first = head;
ListNode second = prev;
while(second!=null){
    if(first.val !=second.val){
        return false;
    }
    first = first.next;
    second = second.next;
}
return true;
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the number of nodes in the linked list. This is because we are scanning the list three times: once to find the midpoint, once to reverse the second half, and once to compare the two halves.
- Space: The space complexity is O(1), which means the space required does not change with the size of the input list. This is because we are only using a constant amount of space to store the pointers and variables, regardless of the size of the input list.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions could include:
- What if the linked list is not singly linked but doubly linked? How would the solution change? 
    - The main difference would be in the reversal step, as we would have to update both the `next` and `prev` pointers of each node. However, finding the midpoint and comparing the two halves would remain similar.
- How would you optimize this solution for extremely large linked lists? 
    - One optimization could be to use a more efficient algorithm for reversing the second half of the list, though the current solution is already quite efficient with O(n) time complexity. Another approach could be to use a data structure like a stack to store the first half of the list while iterating through it, which would allow us to avoid reversing the second half altogether.