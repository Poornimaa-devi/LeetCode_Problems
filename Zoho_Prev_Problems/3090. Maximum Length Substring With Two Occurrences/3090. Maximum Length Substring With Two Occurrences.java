1class Solution {
2    public int maximumLengthSubstring(String s) {
3        int[] freq = new int[26];
4        int left = 0;
5        int maxLen = 0;
6        for(int right=0;right<s.length();right++){
7            int idx = s.charAt(right)-'a';
8            freq[idx]++;
9            while(freq[idx]>2){
10                freq[s.charAt(left)-'a']--;
11                left++;
12            }
13            maxLen = Math.max(maxLen,right-left+1);
14        }
15        return maxLen;
16    }
17}