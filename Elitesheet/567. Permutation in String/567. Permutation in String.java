1import java.util.*;
2class Solution {
3    public boolean checkInclusion(String s1, String s2) {
4        if(s1.length()>s2.length()) return false;
5        int freq1[] = new int[26];
6        int freq2[] = new int[26];
7        for(int i=0;i<s1.length();i++){
8             freq1[s1.charAt(i)-'a']++;
9             freq2[s2.charAt(i)-'a']++;
10        }
11        if(Arrays.equals(freq1,freq2)) return true;
12        for(int right = s1.length();right<s2.length();right++){
13             int left = right - s1.length();
14             freq2[s2.charAt(left)-'a']--;
15             freq2[s2.charAt(right)-'a']++;
16             if(Arrays.equals(freq1,freq2)) return true;
17        }
18        return false;
19    }
20}