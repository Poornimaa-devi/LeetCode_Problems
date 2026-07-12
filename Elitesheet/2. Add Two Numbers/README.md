<h2><a href="https://leetcode.com/problems/add-two-numbers">2. Add Two Numbers</a></h2>

<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;">
<pre><strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,0,8]
<strong>Explanation:</strong> 342 + 465 = 807.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>Output:</strong> [8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
</ul>


---

# 🛍️ Add-Two-Numbers | Explained

## Approach 1 (Iterative Linked List Traversal)
### Intuition
Imagine you are manually adding two numbers digit by digit, where each digit is represented as a node in a linked list. You start from the rightmost digit (least significant) and move towards the left, carrying over any overflow to the next digit. This approach works because it mimics the way we perform arithmetic addition by hand, taking care of carry values and iterating through the digits one by one.

### Approach
The algorithmic steps can be broken down as follows:
1. Initialize pointers for both linked lists, along with a variable to keep track of the carry value.
2. Traverse both linked lists simultaneously, calculating the sum of the current nodes' values and the carry.
3. Update the carry value for the next iteration.
4. Create a new node with the sum modulo 10 as its value and append it to the result linked list.
5. Repeat steps 2-4 until all nodes in both linked lists have been traversed.
6. If a carry value remains after traversing all nodes, append a new node with the carry value to the result linked list.

### Detailed Code Analysis
Let's dive into the provided code:
```javascript
let head, c = head, one = l1, two = l2, carry = 0;
```
Here, `head` and `c` are used as pointers to the current node in the result linked list, with `head` also serving as the starting point of the result list. `one` and `two` are pointers to the current nodes in the input linked lists `l1` and `l2`, respectively. `carry` is initialized to keep track of any overflow.

The code then enters a while loop, which continues as long as there are nodes in either `l1` or `l2` that haven't been processed:
```javascript
while (one || two) {
    let x = 0, y = 0, sum = carry, next, tmpNode;
    if (one.val) {
        x = one.val;
    }
    if (two.val) {
        y = two.val;
    }
    sum += x + y;
    carry = Math.floor(sum / 10);
    next = sum % 10;
```
Inside the loop, `x` and `y` are used to store the values of the current nodes in `l1` and `l2`, respectively. If a node doesn't exist (i.e., `one` or `two` is null), its corresponding variable (`x` or `y`) remains 0. The `sum` is calculated by adding the current node values (`x` and `y`) to the `carry`. The new `carry` is then calculated as the integer part of the `sum` divided by 10, and `next` is the remainder of the `sum` modulo 10, representing the digit value for the new node.

```javascript
tmpNode = new ListNode(next);
if (head == null) {
    head = new ListNode(next);
    c = head;
} else {
    c.next = tmpNode;
    c = c.next;
}
```
Here, a new node (`tmpNode`) is created with `next` as its value. If `head` is null (meaning this is the first iteration), `head` is initialized with a new node having `next` as its value, and `c` is set to `head`. Otherwise, `tmpNode` is appended to the result list by setting `c.next` to `tmpNode` and then moving `c` to `tmpNode`.

```javascript
if (one.next != null) {
    one = one.next;
} else {
    one = false
}
if (two.next != null) {
    two = two.next;
} else {
    two = false
}
```
Finally, the pointers `one` and `two` are moved to the next nodes in their respective lists if they exist. If not, they are set to `false` to indicate that all nodes in that list have been traversed.

### Code
```javascript
var addTwoNumbers = function(l1, l2) {
    let head, c = head, one = l1, two = l2, carry = 0;

    while (one || two) {
        let x = 0, y = 0, sum = carry, next, tmpNode;
        if (one.val) {
            x = one.val;
        }
        if (two.val) {
            y = two.val;
        }
        sum += x + y;
        carry = Math.floor(sum / 10);
        next = sum % 10;
        tmpNode = new ListNode(next);
        if (head == null) {
            head = new ListNode(next);
            c = head;
        } else {
            c.next = tmpNode;
            c = c.next;
        }
        if (one.next != null) {
            one = one.next;
        } else {
            one = false
        }
        if (two.next != null) {
            two = two.next;
        } else {
            two = false
        }
    }
    if (carry > 0) {
        let tmpNode = new ListNode(carry);
        c.next = tmpNode;
    }
    return head;
};
```
### Complexity
- Time: O(max(m, n)), where m and n are the lengths of the input linked lists `l1` and `l2`, respectively. This is because in the worst case, we iterate through all nodes in both lists.
- Space: O(max(m, n)), as we create a new linked list that can be at most max(m, n) + 1 nodes long (in case of a carry at the end).

## 🕵️‍♂️ Follow-up Questions (Optional)
1. Q: How would you optimize the code for very large input linked lists?
A: For very large input linked lists, optimizing memory usage would be key. The current solution already has a linear space complexity, but reducing the constant factors (e.g., using a more efficient node allocation strategy) could help.
2. Q: What if the input linked lists are not non-empty, and we need to handle null inputs?
A: To handle null inputs, you would add a simple check at the beginning of the function to return null if both input lists are null, or to proceed with the single non-null list if one of them is null. This would ensure the function behaves correctly in edge cases.