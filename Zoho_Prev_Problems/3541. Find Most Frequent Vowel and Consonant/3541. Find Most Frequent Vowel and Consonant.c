1class Solution {
2    public int maxFreqSum(String s) {
3        int freq[] = new int[26];
4        int vowel = 0;
5        int consonant=0;
6        for(int i=0;i<s.length();i++){
7            
8            char ch = s.charAt(i);
9            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
10                 freq[ch-'a']++;
11                 vowel = Math.max(vowel,freq[ch-'a']);
12            }else{
13                freq[ch-'a']++;
14                consonant = Math.max(consonant,freq[ch-'a']);
15            }
16        }
17        int total = vowel+consonant;
18        return total;
19    }
20}