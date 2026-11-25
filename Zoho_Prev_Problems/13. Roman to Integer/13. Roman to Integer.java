1import java.util.*;
2
3class Solution {
4    public int romanToInt(String s) {
5        
6        Map<Character, Integer> map = new HashMap<>();
7        map.put('I', 1);
8        map.put('V', 5);
9        map.put('X', 10);
10        map.put('L', 50);
11        map.put('C', 100);
12        map.put('D', 500);
13        map.put('M', 1000);
14        
15        int total = 0;
16        
17        for (int i = 0; i < s.length(); i++) {
18            
19            int current = map.get(s.charAt(i));
20            
21            if (i < s.length() - 1 && current < map.get(s.charAt(i + 1))) {
22                total -= current;  
23            } else {
24                total += current;  
25            }
26        }
27        
28        return total;
29    }
30}
31