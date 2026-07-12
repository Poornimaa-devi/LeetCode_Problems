1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node prev;
6    public Node next;
7    public Node child;
8};
9*/
10
11class Solution {
12    Node flattened = new Node(0);
13    Node tail = flattened;
14
15    public Node flatten(Node head) {
16        traverse(head);
17        Node ans = flattened.next;
18        if (ans != null) ans.prev = null;
19        return ans;
20    }
21
22    public void traverse(Node node) {
23        if (node != null) {
24            Node newNode = node;
25            tail.next = newNode;
26            newNode.prev = tail;
27            tail = newNode;
28
29            Node nextNode = newNode.next;
30            traverse(node.child);
31            node.child = null;
32            traverse(nextNode);
33        }
34    }
35}