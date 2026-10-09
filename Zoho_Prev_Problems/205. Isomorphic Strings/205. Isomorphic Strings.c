1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3       HashMap<Character,Character> map = new HashMap<>();
4       HashSet<Character> set = new HashSet<>();
5       for(int i=0;i<s.length();i++){
6           if(map.containsKey(s.charAt(i))){
7              if(map.get(s.charAt(i))!=t.charAt(i)) return false;
8           }else{
9              if(set.contains(t.charAt(i))) return false;
10              map.put(s.charAt(i),t.charAt(i));
11              set.add(t.charAt(i));
12           }
13       }
14       return true;
15    }
16}