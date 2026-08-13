1class Solution {
2    public int[] secondGreaterElement(int[] nums) {
3        int n = nums.length;
4        int st1 [] = new int[n];
5        int st2 [] = new int[n];
6        int t1 = -1;
7        int t2 = -1;
8        int res[] = new int[n];
9        Arrays.fill(res,-1);
10        int temp[] = new int[n];
11        int top = -1;
12        for(int i=0;i<n;i++){
13            int curr = nums[i];
14            while(t2!=-1 && nums[st2[t2]]  < curr){
15                res[st2[t2--]] = curr;
16            }
17            while(t1!=-1 && nums[st1[t1]] < curr){
18                temp[++top] = st1[t1--];
19            }
20            while(top!=-1){
21                st2[++t2] = temp[top--];
22            }
23            st1[++t1] = i;
24        }
25         return res;
26    }
27}