<h2><a href="https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list">430. Flatten a Multilevel Doubly Linked List</a></h2>

<p>You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional <strong>child pointer</strong>. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a <strong>multilevel data structure</strong> as shown in the example below.</p>

<p>Given the <code>head</code> of the first level of the list, <strong>flatten</strong> the list so that all the nodes appear in a single-level, doubly linked list. Let <code>curr</code> be a node with a child list. The nodes in the child list should appear <strong>after</strong> <code>curr</code> and <strong>before</strong> <code>curr.next</code> in the flattened list.</p>

<p>Return <em>the </em><code>head</code><em> of the flattened list. The nodes in the list must have <strong>all</strong> of their child pointers set to </em><code>null</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/09/flatten11.jpg" style="width: 700px; height: 339px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
<strong>Output:</strong> [1,2,3,7,8,11,12,9,10,4,5,6]
<strong>Explanation:</strong> The multilevel linked list in the input is shown.
After flattening the multilevel linked list it becomes:
<img src="https://assets.leetcode.com/uploads/2021/11/09/flatten12.jpg" style="width: 1000px; height: 69px;">
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/09/flatten2.1jpg" style="width: 200px; height: 200px;">
<pre><strong>Input:</strong> head = [1,2,null,3]
<strong>Output:</strong> [1,3,2]
<strong>Explanation:</strong> The multilevel linked list in the input is shown.
After flattening the multilevel linked list it becomes:
<img src="https://assets.leetcode.com/uploads/2021/11/24/list.jpg" style="width: 300px; height: 87px;">
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = []
<strong>Output:</strong> []
<strong>Explanation:</strong> There could be empty list in the input.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of Nodes will not exceed <code>1000</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>How the multilevel linked list is represented in test cases:</strong></p>

<p>We use the multilevel linked list from <strong>Example 1</strong> above:</p>

<pre> 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL</pre>

<p>The serialization of each level is as follows:</p>

<pre>[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]
</pre>

<p>To serialize all levels together, we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:</p>

<pre>[1,    2,    3, 4, 5, 6, null]
             |
[null, null, 7,    8, 9, 10, null]
                   |
[            null, 11, 12, null]
</pre>

<p>Merging the serialization of each level and removing trailing nulls we obtain:</p>

<pre>[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
</pre>


---

# 🛍️ Flatten-a-Multilevel-Doubly-Linked-List | Explained

## Approach 1 (Recursive Traversal)
### Intuition
Imagine a file system where each folder can contain other folders and files. To flatten this hierarchical structure into a single list, you would need to traverse each folder and its subfolders, adding all the files and subfolders to the list. This problem applies a similar concept to a multilevel doubly linked list, where each node can have a child node. The approach works by recursively traversing the list, adding each node to a new list and updating the child pointers to maintain the correct order.

### Approach
The algorithm starts by initializing a new node (`flattened`) that serves as the beginning of the flattened list. The `tail` variable keeps track of the last node added to the flattened list. The `traverse` function recursively visits each node in the original list. For each node, it adds the node to the flattened list, updates the `tail` pointer, and then recursively traverses the child node (if it exists) and the next node in the original list.

### Detailed Code Analysis
Let's dive into the code:
- `Node flattened = new Node(0);` and `Node tail = flattened;`: These lines initialize the `flattened` node and the `tail` pointer, which will be used to build the new list.
- `public Node flatten(Node head)`: This is the main function that initiates the flattening process by calling `traverse(head)`.
- `Node ans = flattened.next;`: After the traversal, this line retrieves the first node of the flattened list (excluding the dummy node).
- `if (ans != null) ans.prev = null;`: This line ensures that the `prev` pointer of the new head node is `null`, as required.
- The `traverse` function:
  - `if (node != null)`: This checks if the current node exists before processing it.
  - `Node newNode = node;`: This creates a reference to the current node to facilitate adding it to the flattened list without modifying the original list's structure.
  - `tail.next = newNode;` and `newNode.prev = tail;`: These lines add the current node to the end of the flattened list and update the `prev` pointer of the new node to point to the current `tail`.
  - `tail = newNode;`: This updates the `tail` pointer to point to the newly added node.
  - `Node nextNode = newNode.next;`: This line stores the next node in the original list before it is potentially modified by the recursive call.
  - `traverse(node.child); node.child = null;`: These lines recursively flatten the child list and then set the child pointer to `null` to avoid revisiting the same nodes.
  - `traverse(nextNode);`: This line continues the traversal with the next node in the original list.

### Code
```java
class Solution {
    Node flattened = new Node(0);
    Node tail = flattened;

    public Node flatten(Node head) {
        traverse(head);
        Node ans = flattened.next;
        if (ans != null) ans.prev = null;
        return ans;
    }

    public void traverse(Node node) {
        if (node != null) {
            Node newNode = node;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

            Node nextNode = newNode.next;
            traverse(node.child);
            node.child = null;
            traverse(nextNode);
        }
    }
}
```

### Complexity
- Time: The time complexity is O(N), where N is the total number of nodes in the multilevel linked list. This is because each node is visited once during the traversal.
- Space: The space complexity is O(N) as well, due to the recursive call stack in the worst case (when the list is highly nested). The additional space used by the `flattened` list does not count towards the space complexity since it's part of the output.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem could include:
- How would you modify the solution to handle cycles in the list (if any)?
  - Answer: You would need to keep track of visited nodes to detect cycles and handle them appropriately.
- Can you optimize the space complexity of the solution?
  - Answer: The current recursive solution has a space complexity of O(N) due to the recursive call stack. An iterative solution could potentially reduce this, but given the nature of the problem, the space complexity would still be influenced by the need to store the result.