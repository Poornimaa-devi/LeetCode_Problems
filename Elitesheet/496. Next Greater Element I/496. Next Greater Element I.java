1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        Stack<Integer> st = new Stack<>();
4        HashMap<Integer , Integer> map  = new HashMap<>();
5
6            for(int i = nums2.length-1;i>=0;i--){
7                
8                while(!st.isEmpty() && st.peek()<=nums2[i] ){
9                    st.pop();
10                }
11
12                if(st.isEmpty()){
13                        map.put(nums2[i] , -1);
14                }else{
15                    map.put( nums2[i],st.peek() );
16                }
17
18                    st.push(nums2[i]);
19            }
20
21            int[] ans = new int[nums1.length];
22            for(int i =0;i<nums1.length;i++){
23                ans[i]=map.get(nums1[i]);
24            }
25
26            return ans;
27    }
28}