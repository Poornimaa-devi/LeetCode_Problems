1class Solution {
2    public String[] sortPeople(String[] names, int[] heights) {
3        int n = names.length;
4        Map<Integer, String> mapping = new HashMap<>();
5        for (int i = 0; i < n; ++i) {
6            mapping.put(heights[i], names[i]);
7        }
8        Arrays.sort(heights);
9        for (int i = 0; i < n / 2; ++i) {
10            int temp = heights[i];
11            heights[i] = heights[n - 1 - i];
12            heights[n - 1 - i] = temp;
13        }
14        for (int i = 0; i < n; ++i) {
15            names[i] = mapping.get(heights[i]);
16        }
17        return names;
18    }
19}