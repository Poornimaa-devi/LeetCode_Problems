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

## Approach 1: Two-Stack Approach
### Intuition
The core idea behind this approach is to utilize two stacks to mimic the behavior of a queue. A queue follows the First-In-First-Out (FIFO) principle, which means the first element that is added to the queue is the first one to be removed. However, stacks follow the Last-In-First-Out (LIFO) principle, meaning the last element added to the stack is the first one to be removed. By using two stacks, we can leverage this LIFO behavior to achieve the FIFO principle of a queue. Think of it like two boxes where you add items to one box (the "inbox") and then move items from the inbox to the other box (the "outbox") whenever you need to process them in the order they were received.

### Approach
Here's a step-by-step breakdown of how this approach works:
1. When an element is added to the queue (via the `push` operation), it is directly pushed onto the first stack (`s1`).
2. When an element needs to be removed from the queue (via the `pop` operation), we check if the second stack (`s2`) is empty. If it is, we pop all elements from the first stack (`s1`) and push them onto the second stack (`s2`). This effectively reverses the order of the elements, so the oldest element (the one that was added first) is now at the top of the second stack.
3. After ensuring the second stack is not empty, we pop the top element from the second stack (`s2`), which represents the front of the queue, and return it.
4. The `peek` operation follows a similar logic to `pop`, but instead of removing the top element from the second stack, it simply returns its value without removing it.
5. The `empty` operation checks if both stacks are empty, in which case the queue is considered empty.

### Detailed Code Analysis
Let's dive into the provided code:
- The class `MyQueue` is initialized with two private `Stack` objects, `s1` and `s2`. These stacks are used as described in the approach.
- The `push` method simply adds an element to the top of `s1`, which represents adding an element to the back of the queue.
- The `pop` method checks if `s2` is empty. If it is, it transfers all elements from `s1` to `s2` by popping from `s1` and pushing onto `s2`. Then, it pops and returns the top element from `s2`, which is the front of the queue.
- The `peek` method checks if `s2` is not empty. If `s2` is empty, it transfers elements from `s1` to `s2` in the same manner as `pop`. Then, it returns the value of the top element of `s2` without popping it.
- The `empty` method returns `true` if both `s1` and `s2` are empty, indicating the queue is empty.

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
  - `push`: O(1) because it involves a single operation of pushing onto a stack.
  - `pop`: Amortized O(1), but worst-case O(n) when elements need to be transferred from `s1` to `s2`. Here, n is the number of elements in `s1`.
  - `peek`: Similar to `pop`, amortized O(1) and worst-case O(n) for the same reason.
  - `empty`: O(1) because it involves checking the emptiness of two stacks.
- Space: O(n) because in the worst case, we might have all elements in one of the stacks. Here, n is the total number of elements added to the queue.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you optimize the `pop` and `peek` operations to always achieve O(1) time complexity?**
   - One approach to optimize these operations would involve maintaining a reference to the front of the queue. However, given the constraints of using only stacks, the current implementation provides an amortized O(1) time complexity, which is a practical optimization for most scenarios.

2. **What are the implications of using a single stack instead of two stacks for this problem?**
   - Using a single stack would not allow for an efficient implementation of a queue since you cannot directly achieve the FIFO behavior with a single LIFO data structure. The two-stack approach provides a straightforward way to emulate a queue's behavior using stacks.