1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        List<Integer> ans = new ArrayList<>();
4
5        String s = 123456789;
6        String l = String.valueOf(low);
7        String h = String.valueOf(high);
8
9        for(int len=l.length();len<=h.length();len++){
10            for(int start=0;start<=9-len;start++){
11                int num = Integer.parseInt(s.substring(start,start+len));
12                if(num>=low && num<=high){
13                    ans.add(num);
14                }
15            }
16        }
17        return ans;
18    }
19}