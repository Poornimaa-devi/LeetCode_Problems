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
12    public ListNode deleteDuplicates(ListNode head) {
13        ListNode res = head;
14        while(head!=null && head.next!=null){
15
16            if(head.val == head.next.val){
17                head.next = head.next.next;
18            }else{
19            head=head.next;
20            }
21        }
22        return res;
23    }
24}