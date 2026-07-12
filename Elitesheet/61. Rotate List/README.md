<h2><a href="https://leetcode.com/problems/rotate-list">61. Rotate List</a></h2>

<p>Given the <code>head</code> of a linked&nbsp;list, rotate the list to the right by <code>k</code> places.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 450px; height: 191px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5], k = 2
<strong>Output:</strong> [4,5,1,2,3]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 305px; height: 350px;">
<pre><strong>Input:</strong> head = [0,1,2], k = 4
<strong>Output:</strong> [2,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 500]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li><code>0 &lt;= k &lt;= 2 * 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Rotate-List | Explained

## Approach 1 (Optimized)
### Intuition
The intuition behind this approach is to treat the linked list as a circular buffer. When we need to rotate the list to the right by `k` steps, we can calculate the actual number of steps needed by taking the modulus of `k` with the length of the list. This is because after a certain number of rotations, the list will return to its original state. For example, if we have a list of length 5 and we need to rotate it 7 steps to the right, we can simply rotate it 2 steps to the right (7 mod 5 = 2).

### Approach
The approach involves the following steps:
1. Check if the list is empty or only contains one node. If so, return the list as it is.
2. Find the last node of the list and connect it to the head to form a circular buffer.
3. Calculate the actual number of steps needed by taking the modulus of `k` with the length of the list.
4. Find the new tail of the list by moving `steps` nodes from the last node.
5. Find the new head of the list by moving one node from the new tail.
6. Break the circular buffer at the new tail.

### Detailed Code Analysis
Let's dive into the code block line by line:
- Lines 11-12: We define a class `Solution` with a method `rotateRight` that takes a `ListNode` `head` and an integer `k` as input.
- Line 13: We check if the list is empty or only contains one node. If so, we return the list as it is because rotation is not needed.
- Lines 14-19: We find the last node of the list and count the number of nodes in the list. The `last` variable keeps track of the last node, and the `cnt` variable keeps track of the number of nodes.
- Line 20: We connect the last node to the head to form a circular buffer.
- Line 21: We calculate the actual number of steps needed by taking the modulus of `k` with the length of the list.
- Line 22: We calculate the number of steps needed to reach the new tail by subtracting `k` from the length of the list.
- Lines 25-28: We find the new tail of the list by moving `steps` nodes from the last node. The `newtail` variable keeps track of the new tail.
- Line 29: We find the new head of the list by moving one node from the new tail.
- Line 30: We break the circular buffer at the new tail by setting the next pointer of the new tail to null.
- Line 32: We return the new head of the list.

### Code
```python
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k == 0) return head;
        ListNode last = head;
        int cnt = 1;
        while(last.next!=null){
            last=last.next;
            cnt++;
        }
        last.next = head;
        k = k % cnt;
        int steps = cnt-k;
        ListNode newtail = last;
            
        while(steps>0){
            newtail = newtail.next;
            steps--;
        }
       ListNode newhead = newtail.next;
       newtail.next = null;
    
        return newhead;
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(L), where L is the length of the list. This is because we need to traverse the list to find the last node and to find the new tail.
- Space: The space complexity of this solution is O(1), which means the space required does not grow with the size of the input list. We only use a constant amount of space to store the pointers and variables.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
- What if the list is very large and we cannot afford to traverse the entire list? In this case, we could use a two-pointer approach to find the new tail and new head without having to traverse the entire list.
- What if the rotation is not a fixed number of steps, but rather a percentage of the length of the list? In this case, we would need to calculate the actual number of steps needed based on the length of the list and the percentage given.