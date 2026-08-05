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
12    public int[][] spiralMatrix(int m, int n, ListNode head) {
13        int[][] array = new int[m][n];
14        for(int[] row : array){
15           Arrays.fill(row,-1);
16        }
17        int top=0;
18        int bottom = m-1;
19        int left=0;
20        int right = n-1;
21        while(top<=bottom && left<=right && head!=null){
22            for(int i=left;i<=right && head!=null;i++){
23                array[top][i] = head.val;
24                head=head.next;
25            }
26            top++;
27
28            for(int i=top;i<=bottom && head!=null;i++){
29                array[i][right]=head.val;
30                head=head.next;
31            }
32            right--;
33            if(top<=bottom){
34                for(int i=right;i>=left && head!=null;i--){
35                    array[bottom][i]=head.val;
36                    head=head.next;
37                }
38                bottom--;
39            }
40            if(left<=right){
41                for(int i=bottom;i>=top && head!=null;i--){
42                    array[i][left]=head.val;
43                    head=head.next;
44                }
45                left++;
46            }
47        }
48        return array;
49    }
50}