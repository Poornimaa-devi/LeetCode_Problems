<h2><a href="https://leetcode.com/problems/minimum-time-difference">539. Minimum Time Difference</a></h2>

Given a list of 24-hour clock time points in <strong>"HH:MM"</strong> format, return <em>the minimum <b>minutes</b> difference between any two time-points in the list</em>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> timePoints = ["23:59","00:00"]
<strong>Output:</strong> 1
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> timePoints = ["00:00","23:59","00:00"]
<strong>Output:</strong> 0
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= timePoints.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>timePoints[i]</code> is in the format <strong>"HH:MM"</strong>.</li>
</ul>


---

# 🛍️ Minimum-Time-Difference | Explained

## Approach 1: Converting Time Points and Sorting
### Intuition
The core idea of this approach is to convert all time points into a unified unit (minutes) to facilitate comparison and then sort them to find the minimum time difference. This is analogous to arranging a set of clock times in ascending order to easily identify the shortest gaps between them.

### Algorithm Visualized
```mermaid
graph LR;
    A[Time Points] -->|Convert to Minutes|> B(List of Minutes);
    B -->|Sort|> C(Sorted List of Minutes);
    C -->|Calculate Differences|> D(Minimum Time Difference);
```

### Approach
The approach involves four key steps:
1. Convert all time points from the "HH:MM" format to minutes.
2. Sort the converted time points in ascending order.
3. Calculate the differences between consecutive time points to find the minimum gap.
4. Consider the circular case by calculating the difference between the first and last time points, taking into account the full 24-hour cycle (1440 minutes).

### Detailed Code Analysis
- Lines 4-10: A `List` named `vec` is used to store the time points in minutes. The loop iterates over each time point, extracts the hours and minutes using `substring`, converts them to integers, calculates the total minutes since the start of the day, and adds this value to `vec`.
- Line 13: `Collections.sort(vec)` sorts the list of time points in ascending order, which is crucial for calculating the minimum time differences.
- Lines 16-19: The code calculates the differences between consecutive time points and keeps track of the minimum difference found so far in `res`.
- Line 22: The code handles the circular case by calculating the difference between the first and last time points, adding 1440 (the total minutes in a day) to ensure the difference is positive and representative of the minimum time gap in the circular arrangement.

### Code
```java
List<Integer> vec = new ArrayList<>();
for (String timePoint : timePoints) {
    int h = Integer.parseInt(timePoint.substring(0, 2));
    int m = Integer.parseInt(timePoint.substring(3));
    int mins = h * 60 + m;
    vec.add(mins);
}

Collections.sort(vec);

int res = Integer.MAX_VALUE;
for (int i = 1; i < vec.size(); i++) {
    res = Math.min(vec.get(i) - vec.get(i - 1), res);
}

return Math.min(res, 1440 + vec.get(0) - vec.get(vec.size() - 1));
```

### Complexity
- **Time:** The time complexity of this solution is O(n log n) due to the sorting operation, where n is the number of time points. The subsequent loop to calculate the differences is O(n), but it does not dominate the sorting step.
- **Space:** The space complexity is O(n) because we are storing all time points in a list.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the input list is empty or contains only one time point? 
   - The solution does not handle these edge cases explicitly, so additional checks would be necessary to return a meaningful result or an error message.
2. How would you optimize this solution for a very large input list?
   - For a very large list, using a more efficient sorting algorithm or data structure (like a balanced binary search tree) could reduce the time complexity. However, the current approach is appropriate for most practical purposes and the constraints of the LeetCode problem.