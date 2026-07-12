1class Solution {
2    public String getSignature(String s) {
3        int[] count = new int[26];
4        for (char c : s.toCharArray()) {
5            count[c - 'a']++;
6        }
7
8        StringBuilder sb = new StringBuilder();
9        for (int i = 0; i < 26; i++) {
10            if (count[i] != 0) {
11                sb.append((char) ('a' + i)).append(count[i]);
12            }
13        }
14        return sb.toString();
15    }
16
17    public List<List<String>> groupAnagrams(String[] strs) {
18        List<List<String>> result = new ArrayList<>();
19        Map<String, List<String>> groups = new HashMap<>();
20
21        for (String s : strs) {
22            groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
23        }
24
25        result.addAll(groups.values());
26
27        return result;
28    }
29}
30
31