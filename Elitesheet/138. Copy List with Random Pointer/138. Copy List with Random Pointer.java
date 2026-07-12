1/*
2// Definition for a Node.
3class Node {
4    int val;
5    Node next;
6    Node random;
7
8    public Node(int val) {
9        this.val = val;
10        this.next = null;
11        this.random = null;
12    }
13}
14*/
15
16public class Solution {
17    public Node copyRandomList(Node head) {
18        if (head == null) return null;
19        
20        HashMap<Node, Node> oldToNew = new HashMap<>();
21        
22        Node curr = head;
23        while (curr != null) {
24            oldToNew.put(curr, new Node(curr.val));
25            curr = curr.next;
26        }
27        
28        curr = head;
29        while (curr != null) {
30            oldToNew.get(curr).next = oldToNew.get(curr.next);
31            oldToNew.get(curr).random = oldToNew.get(curr.random);
32            curr = curr.next;
33        }
34        
35        return oldToNew.get(head);
36    }
37}