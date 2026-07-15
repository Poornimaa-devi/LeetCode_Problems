<h2><a href="https://leetcode.com/problems/implement-stack-using-queues">225. Implement Stack using Queues</a></h2>

<p>Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (<code>push</code>, <code>top</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyStack</code> class:</p>

<ul>
	<li><code>void push(int x)</code> Pushes element x to the top of the stack.</li>
	<li><code>int pop()</code> Removes the element on the top of the stack and returns it.</li>
	<li><code>int top()</code> Returns the element on the top of the stack.</li>
	<li><code>boolean empty()</code> Returns <code>true</code> if the stack is empty, <code>false</code> otherwise.</li>
</ul>

<p><b>Notes:</b></p>

<ul>
	<li>You must use <strong>only</strong> standard operations of a queue, which means that only <code>push to back</code>, <code>peek/pop from front</code>, <code>size</code> and <code>is empty</code> operations are valid.</li>
	<li>Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue&#39;s standard operations.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MyStack&quot;, &quot;push&quot;, &quot;push&quot;, &quot;top&quot;, &quot;pop&quot;, &quot;empty&quot;]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 2, 2, false]

<strong>Explanation</strong>
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x &lt;= 9</code></li>
	<li>At most <code>100</code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>empty</code>.</li>
	<li>All the calls to <code>pop</code> and <code>top</code> are valid.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you implement the stack using only one queue?</p>


---

# 🛍️ Implement-Stack-using-Queues | Explained

## Approach 1: Using a Single Queue to Simulate a Stack
### Intuition
The core idea behind this approach is to utilize a single queue to mimic the behavior of a stack. In a stack, the last element added is the first one to be removed (Last-In-First-Out, LIFO), whereas in a queue, the first element added is the first one to be removed (First-In-First-Out, FIFO). To simulate a stack using a queue, we can rotate the queue after each push operation so that the most recently added element is at the front of the queue. This rotation ensures that when we perform a pop operation, we're removing the element that was most recently added, thus mimicking the behavior of a stack. 

Think of it like a line of people waiting to get into a concert. When a new person arrives, they go to the back of the line (like adding to a queue). But to simulate a stack, we need to move the new person to the front of the line (by rotating the queue) so they can enter the concert first.

### Approach
The high-level logic flow is as follows:
1. When pushing an element onto the stack, add it to the end of the queue.
2. Then, rotate the queue by removing the front element and adding it to the end until the newly added element is at the front.
3. When popping an element from the stack, simply remove it from the front of the queue.
4. To get the top element of the stack, peek at the front element of the queue.
5. To check if the stack is empty, check if the queue is empty.

### Detailed Code Analysis
Let's dive into the provided code:
```java
public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        
        // Rotate the queue so the most recently added element is at the front
        for(int i=0;i<queue.size()-1;i++){
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
```
Here's what each part of the code does:
- `queue = new LinkedList<>();` initializes a new queue using Java's LinkedList implementation. LinkedLists are a type of queue that follows the FIFO principle, making them suitable for this problem. They also offer efficient add and remove operations from both ends.
- `public void push(int x)` adds an element `x` to the stack:
  - `queue.add(x);` adds `x` to the end of the queue.
  - The for loop rotates the queue so that `x` is moved to the front. It does this by repeatedly removing the front element and adding it to the end until `x` reaches the front.
- `public int pop()` removes the top element from the stack, which is the front element of the queue, due to the rotation performed in the `push` method.
- `public int top()` returns the top element of the stack without removing it, which is the front element of the queue.
- `public boolean empty()` checks if the stack is empty by checking if the queue is empty.

### Code
```java
public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        
        for(int i=0;i<queue.size()-1;i++){
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
```

### Complexity
- Time:
  - `push(x)` has a time complexity of O(n), where n is the number of elements in the stack. This is because after adding `x`, we rotate the queue, which involves n-1 remove and add operations.
  - `pop()`, `top()`, and `empty()` have a time complexity of O(1) since they only involve a single queue operation.
- Space: The space complexity is O(n), where n is the number of elements in the stack. This is because in the worst case, the queue will hold all n elements.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if we wanted to optimize the push operation?** 
   - One potential optimization could involve using two queues instead of one. However, the provided code utilizes a single queue, which simplifies the implementation but results in a less efficient push operation. To optimize, consider using two queues and alternating between them for push and pop operations to reduce the number of elements that need to be rotated.

2. **How does this implementation handle edge cases?**
   - Edge cases, such as pushing and popping from an empty stack or peeking at an empty stack, are handled implicitly by the queue's behavior. Attempting to pop from or peek at an empty stack will result in a `NoSuchElementException`, which can be caught and handled as needed. This implementation assumes that such edge cases will be managed by the caller.