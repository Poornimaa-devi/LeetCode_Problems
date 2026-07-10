1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        HashSet<Character> set = new HashSet<>();
4        int maxlen = 0;
5        int left=0;
6        for(int right=0;right<s.length();right++){
7            char ch = s.charAt(right);
8            while(set.contains(ch)){ 
9                set.remove(s.charAt(left));
10                left++;
11            }
12            set.add(ch);
13           maxlen = Math.max(maxlen,right-left+1);
14        }
15        return maxlen;
16    }
17}