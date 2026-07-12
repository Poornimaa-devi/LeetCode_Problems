<h2><a href="https://leetcode.com/problems/combination-sum-ii">40. Combination Sum II</a></h2>

<p>Given a collection of candidate numbers (<code>candidates</code>) and a target number (<code>target</code>), find all unique combinations in <code>candidates</code>&nbsp;where the candidate numbers sum to <code>target</code>.</p>

<p>Each number in <code>candidates</code>&nbsp;may only be used <strong>once</strong> in the combination.</p>

<p><strong>Note:</strong>&nbsp;The solution set must not contain duplicate combinations.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> candidates = [10,1,2,7,6,1,5], target = 8
<strong>Output:</strong> 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
<strong>Output:</strong> 
[
[1,2,2],
[5]
]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
	<li><code>1 &lt;= target &lt;= 30</code></li>
</ul>


---

# 🛍️ Combination-Sum-II | Explained

## Approach 1 (Optimized Backtracking)
### Intuition
The given problem is a classic example of a combination sum problem with a twist - each number in the combination must be unique. To solve this, we can use a backtracking approach. Think of backtracking as exploring all possible paths in a maze. In this case, we're exploring all possible combinations of numbers that add up to the target. The intuition behind this approach is to use a recursive function to add numbers to our current combination, and when we reach a point where we can't add any more numbers (either because we've reached the target or we've exceeded it), we backtrack and try a different path.

### Approach
Here's a step-by-step breakdown of the algorithmic logic:

1. Sort the input array in ascending order to make it easier to break out of the loop when the current number exceeds the target.
2. Initialize an empty list to store the result and an empty list to store the current combination.
3. Start a recursive backtracking function with the initial index set to 0.
4. Inside the backtracking function, check if the target has been reached. If so, add the current combination to the result list.
5. If the target is less than 0, return immediately to backtrack.
6. Iterate through the input array starting from the current index. For each number:
   - Check if the number exceeds the target. If so, break out of the loop because all subsequent numbers will also exceed the target due to the sorting.
   - Check if the current number is the same as the previous one and we're not at the first index. If so, skip this number to avoid duplicates in the combination.
   - Add the current number to the current combination.
   - Recursively call the backtracking function with the updated target and the next index.
   - Remove the last added number from the current combination to backtrack.

### Detailed Code Analysis
Let's dive into the code:

- Line 2: `public List<List<Integer>> combinationSum2(int[] candidates, int target)`: This is the main function where we initialize the input array and the target.
- Line 3: `List<List<Integer>> result = new ArrayList<>();`: We initialize an empty list to store the result.
- Line 4: `Arrays.sort(candidates);`: We sort the input array in ascending order.
- Line 5: `backtrack(candidates, target, 0, result, new ArrayList<>())`: We start the recursive backtracking function with the initial index set to 0 and an empty list for the current combination.
- Inside the `backtrack` function:
  - Line 9: `if (target == 0)`: We check if the target has been reached.
  - Line 10: `result.add(new ArrayList<>(l1))`: If the target has been reached, we add the current combination to the result list.
  - Line 12: `if (target < 0)`: We check if the target is less than 0.
  - Line 13: `return`: If the target is less than 0, we return immediately to backtrack.
  - Line 15: `for (int i = index; i < candidates.length; i++)`: We iterate through the input array starting from the current index.
  - Line 16: `if (candidates[i] > target)`: We check if the current number exceeds the target.
  - Line 17: `break`: If the current number exceeds the target, we break out of the loop.
  - Line 19: `if (i > index && candidates[i] == candidates[i - 1])`: We check if the current number is the same as the previous one and we're not at the first index.
  - Line 20: `l1.add(candidates[i])`: We add the current number to the current combination.
  - Line 21: `backtrack(candidates, target - candidates[i], i + 1, result, l1)`: We recursively call the backtracking function with the updated target and the next index.
  - Line 22: `l1.remove(l1.size() - 1)`: We remove the last added number from the current combination to backtrack.

### Code
```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public static void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> l1) {
        if (target == 0) {
            result.add(new ArrayList<>(l1));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            l1.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, result, l1);
            l1.remove(l1.size() - 1);
        }
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(2^n) in the worst case, where n is the length of the input array. This is because in the worst case, we might have to explore all possible combinations of the input array. However, the sorting and the breaking out of the loop when the current number exceeds the target reduce the time complexity in practice. The space complexity of the sorting is O(n log n).
- Space: The space complexity is O(n) for the recursion stack and the space used to store the result. The maximum depth of the recursion tree is n, and we use O(n) space to store the current combination and the result.

## 🕵️‍♂️ Follow-up Questions (Optional)
- What if the input array contains negative numbers? In this case, the solution would need to be modified to handle negative numbers correctly. One possible approach would be to separate the positive and negative numbers and handle them separately.
- How can we optimize the solution further? One possible optimization would be to use a more efficient sorting algorithm, such as counting sort or radix sort, if the input array contains a limited range of numbers. Another possible optimization would be to use a more efficient data structure, such as a linked list, to store the current combination and the result.