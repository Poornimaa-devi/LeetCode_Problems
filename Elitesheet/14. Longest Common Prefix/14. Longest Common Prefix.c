1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3    if (strs == null || strs.length == 0) {
4        return ;
5    }
6    
7    String prefix = strs[0];
8    for (int i = 1; i < strs.length; i++) {
9        while (!strs[i].startsWith(prefix)) {
10            prefix = prefix.substring(0, prefix.length() - 1);
11            if (prefix.isEmpty()) {
12                return ;
13            }
14        }
15    }
16    return prefix;
17}
18
19}