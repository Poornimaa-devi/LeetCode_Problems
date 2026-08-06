<h2><a href="https://leetcode.com/problems/min-stack">155. Min Stack</a></h2>

<p>Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.</p>

<p>Implement the <code>MinStack</code> class:</p>

<ul>
	<li><code>MinStack()</code> initializes the stack object.</li>
	<li><code>void push(int value)</code> pushes the element <code>value</code> onto the stack.</li>
	<li><code>void pop()</code> removes the element on the top of the stack.</li>
	<li><code>int top()</code> gets the top element of the stack.</li>
	<li><code>int getMin()</code> retrieves the minimum element in the stack.</li>
</ul>

<p>You must implement a solution with <code>O(1)</code> time complexity for each function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

<strong>Output</strong>
[null,null,null,null,-3,null,0,-2]

<strong>Explanation</strong>
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
	<li>Methods <code>pop</code>, <code>top</code> and <code>getMin</code> operations will always be called on <strong>non-empty</strong> stacks.</li>
	<li>At most <code>3 * 10<sup>4</sup></code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>getMin</code>.</li>
</ul>


---

# 🛍️ Min-Stack | Explained

## Approach 1: Doubly Linked List with Current Min Tracking
### Intuition
The core idea behind this approach is to utilize a doubly linked list to implement a stack. Each node in the stack keeps track of its own value and the current minimum value in the stack at the time of its insertion. This allows for efficient retrieval of the minimum value without having to scan through the entire stack. The intuition can be thought of as maintaining a "snapshot" of the minimum value at each node, which can be updated as new nodes are added or removed.

### Algorithm Visualized
```mermaid
graph LR;
    A[Push val] -->|Create new node|> B(New Node);
    B -->|Update min if needed|> C(Update min);
    C -->|Add to top of stack|> D(Stack);
    D -->|Update prev/next pointers|> E(Updated Stack);
    E -->|Return|> F(Return);
    F -->|GetMin|> G(GetMin);
    G -->|Return current min|> H(Return current min);
```

### Approach
The algorithm works as follows:
1. Initialize the stack with a null top node and a minimum value of `Integer.MAX_VALUE`.
2. When pushing a new value onto the stack, create a new node with the given value and the current minimum value. Update the top node and minimum value if necessary.
3. When popping a value from the stack, update the top node to its previous node and reset the minimum value to the current minimum value of the new top node.
4. The `top` and `getMin` operations simply return the value of the top node and the current minimum value, respectively.

### Detailed Code Analysis
Let's take a closer look at the code:
- The `ListNode` class represents a node in the doubly linked list, with fields for the node's value, current minimum value, and pointers to the next and previous nodes.
- In the `push` method, a new node is created with the given value and the current minimum value. If the stack is empty, the new node becomes the top node. Otherwise, the new node is added to the top of the stack, and the previous top node's next pointer is updated.
- In the `pop` method, the top node is updated to its previous node, and the minimum value is reset to the current minimum value of the new top node.
- The `top` and `getMin` methods simply return the value of the top node and the current minimum value, respectively.

### Code
```java
public class ListNode{
    int value;
    int currentmin;
    ListNode next;
    ListNode prev;
    ListNode(int val,int currmin){
        this.value = val;
        this.currentmin = currmin;
    }
}

class MinStack {

    int min;
    ListNode top;

    public MinStack() {
        top = null;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(top == null){
            min = Math.min(val,min);
            ListNode newnode = new ListNode(val,min);
            top = newnode;
        }
        else{
            min = Math.min(val,min);
            ListNode newnode = new ListNode(val,min);
            top.next = newnode;
            newnode.prev = top;
            top = newnode;
        }
    }
    
    public void pop() {
        top = top.prev;
        if(top != null){
            top.next = null;
            min = top.currentmin;
        }
        else{
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.currentmin;
    }
}
```

### Complexity
- **Time:** The time complexity of the `push`, `pop`, `top`, and `getMin` operations is O(1), since each operation only involves updating a constant number of nodes and pointers.
- **Space:** The space complexity is O(n), where n is the number of elements in the stack, since each node in the stack requires a constant amount of space to store its value, current minimum value, and pointers to its neighbors.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
- How would you implement a Min-Stack using a single array instead of a doubly linked list?
- How would you modify the Min-Stack to also support a `max` operation, which returns the maximum value in the stack?