<h2><a href="https://leetcode.com/problems/copy-list-with-random-pointer">138. Copy List with Random Pointer</a></h2>

<p>A linked list of length <code>n</code> is given such that each node contains an additional random pointer, which could point to any node in the list, or <code>null</code>.</p>

<p>Construct a <a href="https://en.wikipedia.org/wiki/Object_copying#Deep_copy" target="_blank"><strong>deep copy</strong></a> of the list. The deep copy should consist of exactly <code>n</code> <strong>brand new</strong> nodes, where each new node has its value set to the value of its corresponding original node. Both the <code>next</code> and <code>random</code> pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. <strong>None of the pointers in the new list should point to nodes in the original list</strong>.</p>

<p>For example, if there are two nodes <code>X</code> and <code>Y</code> in the original list, where <code>X.random --&gt; Y</code>, then for the corresponding two nodes <code>x</code> and <code>y</code> in the copied list, <code>x.random --&gt; y</code>.</p>

<p>Return <em>the head of the copied linked list</em>.</p>

<p>The linked list is represented in the input/output as a list of <code>n</code> nodes. Each node is represented as a pair of <code>[val, random_index]</code> where:</p>

<ul>
	<li><code>val</code>: an integer representing <code>Node.val</code></li>
	<li><code>random_index</code>: the index of the node (range from <code>0</code> to <code>n-1</code>) that the <code>random</code> pointer points to, or <code>null</code> if it does not point to any node.</li>
</ul>

<p>Your code will <strong>only</strong> be given the <code>head</code> of the original linked list.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/12/18/e1.png" style="width: 700px; height: 142px;">
<pre><strong>Input:</strong> head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
<strong>Output:</strong> [[7,null],[13,0],[11,4],[10,2],[1,0]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/12/18/e2.png" style="width: 700px; height: 114px;">
<pre><strong>Input:</strong> head = [[1,1],[2,1]]
<strong>Output:</strong> [[1,1],[2,1]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/12/18/e3.png" style="width: 700px; height: 122px;"></strong></p>

<pre><strong>Input:</strong> head = [[3,null],[3,0],[3,null]]
<strong>Output:</strong> [[3,null],[3,0],[3,null]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
	<li><code>Node.random</code> is <code>null</code> or is pointing to some node in the linked list.</li>
</ul>


---

# 🛍️ Copy-List-with-Random-Pointer | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to create a copy of the original linked list while also preserving the random pointers. This can be thought of as creating a mirror image of the original list, where each node in the original list has a corresponding node in the copied list. The random pointers are then updated to point to the corresponding nodes in the copied list. This approach works because it ensures that the relationships between nodes are preserved, allowing us to efficiently create a copy of the list.

### Approach
The approach involves two main steps:
1. Create a copy of each node in the original list and store the mapping between the original nodes and their copies in a hash map.
2. Update the next and random pointers of each node in the copied list to point to the corresponding nodes.

### Detailed Code Analysis
Let's dive into the code block:
```java
public class Solution {
    public Node copyRandomList(Node head) {
        // If the list is empty, return null
        if (head == null) return null;
        
        // Create a hash map to store the mapping between original nodes and their copies
        HashMap<Node, Node> oldToNew = new HashMap<>();
        
        // Create a copy of each node in the original list and store the mapping
        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // Update the next and random pointers of each node in the copied list
        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }
        
        // Return the head of the copied list
        return oldToNew.get(head);
    }
}
```
The code uses a hash map `oldToNew` to store the mapping between the original nodes and their copies. It first creates a copy of each node in the original list and stores the mapping in the hash map. Then, it updates the next and random pointers of each node in the copied list by retrieving the corresponding nodes from the hash map.

The choice of using a hash map is due to its efficient lookup time, which allows us to quickly retrieve the corresponding node in the copied list. The `Node` class is used to represent each node in the list, with `val` representing the node's value, `next` representing the next node in the list, and `random` representing the random pointer.

### Code
```java
public Node copyRandomList(Node head) {
    if (head == null) return null;
    
    HashMap<Node, Node> oldToNew = new HashMap<>();
    
    Node curr = head;
    while (curr != null) {
        oldToNew.put(curr, new Node(curr.val));
        curr = curr.next;
    }
    
    curr = head;
    while (curr != null) {
        oldToNew.get(curr).next = oldToNew.get(curr.next);
        oldToNew.get(curr).random = oldToNew.get(curr.random);
        curr = curr.next;
    }
    
    return oldToNew.get(head);
}
```
### Complexity
- Time: The time complexity of this approach is O(n), where n is the number of nodes in the list. This is because we make two passes through the list: one to create the copies of the nodes and another to update the pointers.
- Space: The space complexity of this approach is also O(n), where n is the number of nodes in the list. This is because we use a hash map to store the mapping between the original nodes and their copies, which requires O(n) space.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem include:
- What if the list contains cycles? How would you handle this case?
- Can you optimize the space complexity of the solution?
- How would you implement this solution in a language that doesn't have a built-in hash map, such as C?