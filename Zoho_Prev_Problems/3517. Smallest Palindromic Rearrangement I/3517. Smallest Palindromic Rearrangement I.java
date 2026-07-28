1class Solution {
2    public String smallestPalindrome(String s) {
3
4        int n = s.length();
5
6        //Count frequency of each character
7        int[] freq = new int[26];
8        for(char ch:s.toCharArray())
9        {
10            freq[ch - 'a']++;
11        }
12
13        char[] ans = new char[n];
14        int left = 0;
15        int right = n-1;
16
17        //Place character pairs
18        for(int i=0; i < 26; i++)
19        {
20            while(freq[i] >= 2)
21            {
22                char ch = (char)('a' + i);
23                ans[left++] = ch;
24                ans[right--] = ch;
25                freq[i] -= 2;
26            }
27        }
28
29        //Place the middle character (if any)
30        for(int i=0; i < 26; i++)
31        {
32            if(freq[i] == 1)
33            {
34                ans[left] = (char)('a' + i);
35                break;
36            }
37        }
38
39        return new String(ans);
40        
41    }
42}