1class Solution {
2    public int findMinDifference(List<String> timePoints) {
3        // Step 1: Convert all time points to minutes and store in a list
4        List<Integer> vec = new ArrayList<>();
5        for (String timePoint : timePoints) {
6            int h = Integer.parseInt(timePoint.substring(0, 2));
7            int m = Integer.parseInt(timePoint.substring(3));
8            int mins = h * 60 + m;
9            vec.add(mins);
10        }
11        
12        // Step 2: Sort the time points
13        Collections.sort(vec);
14        
15        // Step 3: Calculate the minimum difference
16        int res = Integer.MAX_VALUE;
17        for (int i = 1; i < vec.size(); i++) {
18            res = Math.min(vec.get(i) - vec.get(i - 1), res);
19        }
20        
21        // Step 4: Handle the circular case (difference between the first and last time points)
22        return Math.min(res, 1440 + vec.get(0) - vec.get(vec.size() - 1));
23    }
24}