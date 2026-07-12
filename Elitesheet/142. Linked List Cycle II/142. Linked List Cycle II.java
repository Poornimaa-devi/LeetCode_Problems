1public class Solution {
2    public ListNode detectCycle(ListNode head) {
3        
4        if (head == null) return null;
5
6        ListNode slow = head;
7        ListNode fast = head;
8
9        
10        while (fast != null && fast.next != null) {
11            slow = slow.next;
12            fast = fast.next.next;
13
14            
15            if (slow == fast) {
16                ListNode entry = head;
17                while(entry!=slow){
18                    entry=entry.next;
19                    slow=slow.next;
20                }
21                return entry;
22            }
23        }
24
25        return null;
26    }
27}