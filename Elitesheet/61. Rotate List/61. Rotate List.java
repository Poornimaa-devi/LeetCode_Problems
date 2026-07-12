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
12    public ListNode rotateRight(ListNode head, int k) {
13        if(head==null || head.next == null || k == 0) return head;
14        ListNode last = head;
15        int cnt = 1;
16        while(last.next!=null){
17            last=last.next;
18            cnt++;
19        }
20        last.next = head;
21        k = k % cnt;
22        int steps = cnt-k;
23        ListNode newtail = last;
24            
25            while(steps>0){
26                newtail = newtail.next;
27                steps--;
28            }
29           ListNode newhead = newtail.next;
30           newtail.next = null;
31        
32        return newhead;
33    }
34}