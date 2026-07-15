<h2><a href="https://leetcode.com/problems/implement-queue-using-stacks">232. Implement Queue using Stacks</a></h2>

<p>Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (<code>push</code>, <code>peek</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyQueue</code> class:</p>

<ul>
	<li><code>void push(int x)</code> Pushes element x to the back of the queue.</li>
	<li><code>int pop()</code> Removes the element from the front of the queue and returns it.</li>
	<li><code>int peek()</code> Returns the element at the front of the queue.</li>
	<li><code>boolean empty()</code> Returns <code>true</code> if the queue is empty, <code>false</code> otherwise.</li>
</ul>

<p><strong>Notes:</strong></p>

<ul>
	<li>You must use <strong>only</strong> standard operations of a stack, which means only <code>push to top</code>, <code>peek/pop from top</code>, <code>size</code>, and <code>is empty</code> operations are valid.</li>
	<li>Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 1, 1, false]

<strong>Explanation</strong>
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x &lt;= 9</code></li>
	<li>At most <code>100</code>&nbsp;calls will be made to <code>push</code>, <code>pop</code>, <code>peek</code>, and <code>empty</code>.</li>
	<li>All the calls to <code>pop</code> and <code>peek</code> are valid.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you implement the queue such that each operation is <strong><a href="https://en.wikipedia.org/wiki/Amortized_analysis" target="_blank">amortized</a></strong> <code>O(1)</code> time complexity? In other words, performing <code>n</code> operations will take overall <code>O(n)</code> time even if one of those operations may take longer.</p>


---

# 🛍️ Implement-Queue-using-Stacks | Explained

## Approach 1 (Optimized Two-Stack Implementation)
### Intuition
Imagine you have two stacks of plates, `s1` and `s2`. You can add plates to the top of `s1`, but to remove a plate from the "front" (the bottom plate in `s1`), you'd have to first move all the plates from `s1` to `s2` to reverse their order. Once the plates are in `s2`, you can simply pop the top one off to remove the front plate. This process of moving plates from `s1` to `s2` allows you to mimic a queue's First-In-First-Out (FIFO) behavior using two stacks.

### Approach
The approach involves the following steps:
- When adding an element, simply push it onto `s1`.
- When removing an element (popping), check if `s2` is empty. If it is, move all elements from `s1` to `s2` to reverse their order, then pop the top element from `s2`.
- To peek at the front element, follow the same logic as popping but instead of popping the element from `s2`, just peek at it.
- To check if the queue is empty, verify that both `s1` and `s2` are empty.

### Detailed Code Analysis
Let's break down the provided code:
- `private Stack<Integer> s1 = new Stack<>();` and `private Stack<Integer> s2 = new Stack<>();` declare the two stacks, `s1` and `s2`, which are used to implement the queue.
- In the `push(int x)` method, `s1.push(x);` simply adds the element `x` to the top of `s1`.
- In the `pop()` method:
  - `if (s2.isEmpty())` checks if `s2` is empty. If it is, it means we need to move elements from `s1` to `s2` to reverse their order.
  - `while (!s1.isEmpty()) s2.push(s1.pop());` does this reversal by popping elements from `s1` and pushing them onto `s2`.
  - `return s2.pop();` then removes and returns the top element from `s2`, which is the front of the queue.
- In the `peek()` method:
  - It first checks if `s2` is not empty and returns the top element of `s2` if it's not empty.
  - If `s2` is empty, it moves elements from `s1` to `s2` (just like in `pop()`) and then peeks at the top element of `s2`.
- In the `empty()` method, `return s1.isEmpty() && s2.isEmpty();` checks if both stacks are empty, indicating the queue is empty.

### Code
```java
class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
```

### Complexity
- Time:
  - `push(int x)`: O(1) since it's just a simple push operation onto `s1`.
  - `pop()`: Amortized O(1), but worst-case O(n) when `s2` is empty and all elements need to be moved from `s1` to `s2`.
  - `peek()`: Similar to `pop()`, amortized O(1) but worst-case O(n) when `s2` is empty.
  - `empty()`: O(1) since it's just checking if both stacks are empty.
- Space: O(n) since in the worst case, we might have all elements stored in either `s1` or `s2` (or split between them).

## 🕵️‍♂️ Follow-up Questions (Optional)
- **Q:** How would you optimize the implementation if you knew the maximum size of the queue beforehand?
  - **A:** Knowing the maximum size beforehand allows for potential optimizations in memory allocation for the stacks, but the basic algorithm remains the same.
- **Q:** What are the trade-offs between using this two-stack implementation versus other queue implementations (e.g., linked lists)?
  - **A:** The two-stack implementation offers simplicity and can be efficient for certain use cases, but other implementations like linked lists might offer better performance for insertion and deletion at arbitrary positions or better memory usage for sparse queues.