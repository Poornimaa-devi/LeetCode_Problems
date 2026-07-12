1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int n1 = nums1.length;
4        int n2 = nums2.length;
5        int n = n1 + n2;
6        int[] new_arr = new int[n];
7
8        int i=0, j=0, k=0;
9
10        while (i<=n1 && j<=n2) {
11            if (i == n1) {
12                while(j<n2) new_arr[k++] = nums2[j++];
13                break;
14            } else if (j == n2) {
15                while (i<n1) new_arr[k++] = nums1[i++];
16                break;
17            }
18
19            if (nums1[i] < nums2[j]) {
20                new_arr[k++] = nums1[i++];
21            } else {
22                new_arr[k++] = nums2[j++];
23            }
24        }
25
26        if (n%2==0) return (float)(new_arr[n/2-1] + new_arr[n/2])/2;
27        else return new_arr[n/2];
28    }
29}