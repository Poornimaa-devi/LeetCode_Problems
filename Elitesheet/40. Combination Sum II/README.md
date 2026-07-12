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
Imagine you're shopping at a store, and you want to buy a combination of items that add up to a certain amount of money. The items are arranged in ascending order of price, and you can't buy the same item more than once. This problem is similar, where we have an array of candidates (item prices) and a target sum. We use backtracking to explore all possible combinations of candidates that add up to the target sum.

### Approach
The algorithm works by:
1. Sorting the candidates array in ascending order.
2. Starting from the first candidate, recursively adding each candidate to the current combination and exploring further.
3. If the current combination exceeds the target sum, we stop exploring this branch.
4. If the current combination equals the target sum, we add it to the result list.
5. To avoid duplicates, we skip the same candidate if it's already been used in the current combination.

### Detailed Code Analysis
Let's dive into the code:
- We start by initializing an empty result list `result` and sorting the `candidates` array in ascending order (lines 3-4).
- We then call the `backtrack` function with the initial parameters: `candidates`, `target`, `0` (starting index), `result`, and an empty list `l1` to store the current combination (line 5).
- In the `backtrack` function:
  - If the `target` becomes `0`, we add the current combination `l1` to the `result` list (lines 9-11).
  - If the `target` becomes negative, we stop exploring this branch (lines 12-14).
  - We iterate through the `candidates` array starting from the current `index`. For each candidate:
    - If the candidate exceeds the `target`, we break the loop since all subsequent candidates will also exceed the `target` due to the sorting (lines 16-18).
    - If we've already used the same candidate in the current combination, we skip it to avoid duplicates (line 19).
    - We add the candidate to the current combination `l1` (line 20).
    - We recursively call the `backtrack` function with the updated parameters: `candidates`, `target - candidates[i]`, `i + 1` (to avoid using the same candidate again), `result`, and `l1` (line 21).
    - After the recursive call, we remove the last added candidate from `l1` to backtrack and explore other branches (line 22).

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
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            l1.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, result, l1);
            l1.remove(l1.size() - 1);
        }
    }
}
```

### Complexity
- Time: The time complexity is O(2^n), where n is the number of candidates. In the worst case, we might need to explore all possible combinations of candidates. However, the sorting and duplicate avoidance mechanisms help reduce the number of branches to explore. The average time complexity is O(2^m), where m is the number of unique candidates.
- Space: The space complexity is O(m), where m is the maximum depth of the recursion tree. This corresponds to the maximum size of the current combination `l1`. The `result` list stores all combinations that sum up to the target, which can require up to O(n) space in the worst case.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the `candidates` array is not sorted, and we still want to use backtracking to solve the problem? 
   - We can sort the array as a preprocessing step before applying the backtracking approach.

2. How can we optimize the solution if the `target` sum is very large, and the `candidates` array contains a mix of small and large numbers?
   - We can use a more efficient pruning strategy by breaking the loop as soon as the current candidate exceeds the remaining `target` sum. This is already implemented in the code. Additionally, we can consider using a more advanced algorithm, such as dynamic programming, to solve the problem more efficiently.