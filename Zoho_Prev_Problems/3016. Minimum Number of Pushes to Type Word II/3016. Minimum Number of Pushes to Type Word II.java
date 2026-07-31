1class Solution {
2    public int minimumPushes(String word) {
3        int freq[]=new int[26];
4        for(char ch : word.toCharArray()){
5            freq[ch-'a']++;
6        }
7        Arrays.sort(freq);
8
9        int totcount=0;
10        int key=0;
11
12        for(int i=25;i>=0;i--){
13            if(freq[i]==0) break;
14
15            int mul = (key/8)+1;
16            totcount+=mul*freq[i];
17            key++;
18        }
19        return totcount;
20    }
21}