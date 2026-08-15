1class Solution {
2    public String minWindow(String s, String t) {
3        if(s.length()<t.length()) return ;
4        int tarfreq[] = new int[128];
5        for(int i=0;i<t.length();i++){
6            tarfreq[t.charAt(i)]++;
7        }
8        int left=0;
9        int minlen = Integer.MAX_VALUE;
10        int start = -1;
11        int req = t.length();
12        int window[] = new int[128];
13        for(int right=0;right<s.length();right++){
14            char rightidx = s.charAt(right);
15            if(window[rightidx]<tarfreq[rightidx]){
16                req--;
17            }
18            window[rightidx]++;
19            while(req==0){
20                int currlen = right-left+1;
21                if(currlen < minlen){
22                    minlen = currlen;
23                    start = left;
24                }
25                char leftidx = s.charAt(left);
26                window[leftidx]--;
27                if(window[leftidx]<tarfreq[leftidx]){
28                   req++;
29                }
30                left++;
31            }
32        }
33        if(start==-1) return ;
34        else return s.substring(start,start+minlen);
35    }
36}