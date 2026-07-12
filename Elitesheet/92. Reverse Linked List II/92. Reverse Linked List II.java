1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        ListNode dummy = new ListNode(0);
14        dummy.next = head;
15        ListNode leftPre = dummy;
16        ListNode currNode = head;
17        for(int i = 0;i < left-1;i++){
18            leftPre = leftPre.next;
19            currNode = currNode.next;
20        }
21        ListNode preNode = null;
22        ListNode subListHead = currNode;
23        for(int i = 0;i <= right-left;i++){
24            ListNode nextNode = currNode.next;
25            currNode.next = preNode;
26            preNode = currNode;
27            currNode = nextNode;
28        }
29        leftPre.next = preNode;
30        subListHead.next = currNode;
31
32        return dummy.next;
33    }
34}