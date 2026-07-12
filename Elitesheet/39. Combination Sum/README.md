<h2><a href="https://leetcode.com/problems/combination-sum">39. Combination Sum</a></h2>

<p>Given an array of <strong>distinct</strong> integers <code>candidates</code> and a target integer <code>target</code>, return <em>a list of all <strong>unique combinations</strong> of </em><code>candidates</code><em> where the chosen numbers sum to </em><code>target</code><em>.</em> You may return the combinations in <strong>any order</strong>.</p>

<p>The <strong>same</strong> number may be chosen from <code>candidates</code> an <strong>unlimited number of times</strong>. Two combinations are unique if the <span data-keyword="frequency-array" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class="">frequency</button></span> of at least one of the chosen numbers is different.</p>

<p>The test cases are generated such that the number of unique combinations that sum up to <code>target</code> is less than <code>150</code> combinations for the given input.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> candidates = [2,3,6,7], target = 7
<strong>Output:</strong> [[2,2,3],[7]]
<strong>Explanation:</strong>
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> candidates = [2,3,5], target = 8
<strong>Output:</strong> [[2,2,2,2],[2,3,3],[3,5]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> candidates = [2], target = 1
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= candidates.length &lt;= 30</code></li>
	<li><code>2 &lt;= candidates[i] &lt;= 40</code></li>
	<li>All elements of <code>candidates</code> are <strong>distinct</strong>.</li>
	<li><code>1 &lt;= target &lt;= 40</code></li>
</ul>


---

# 🛍️ Combination-Sum | Explained

## Approach 1 (Backtracking)
### Intuition
The core idea behind this approach is to use a backtracking strategy to explore all possible combinations of numbers that sum up to the target. Imagine you're trying to fill a basket with a specific capacity (target) using different sized boxes (candidates). You start by placing a box in the basket and then recursively try to fill the remaining space with other boxes. If you can't fill the basket with the current set of boxes, you remove the last box (backtrack) and try a different combination. This process continues until you find all valid combinations that fill the basket exactly.

### Approach
The high-level logic flow is as follows:
1. Initialize an empty result list to store all valid combinations.
2. Define a recursive backtracking function that takes the current combination, result list, candidates, target, and current index as parameters.
3. In the backtracking function, check if the target becomes zero. If so, add the current combination to the result list.
4. If the target becomes negative, stop exploring the current branch and backtrack.
5. Iterate through the candidates starting from the current index, add each candidate to the current combination, and recursively call the backtracking function with the updated target and combination.
6. After each recursive call, remove the last added candidate from the combination to backtrack and explore other branches.

### Detailed Code Analysis
Let's dive into the code block:

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(new ArrayList<>(), result, candidates, target, 0);
    return result;
}
```

In this code block:
- A `result` list is initialized to store all valid combinations.
- The `backtrack` function is called with an empty combination, `result` list, `candidates`, `target`, and initial index `0`.
- The `backtrack` function is responsible for exploring all possible combinations recursively.

Now, let's analyze the `backtrack` function:

```java
public static void backtrack(List<Integer> list1, List<List<Integer>> result, int[] nums, int target, int idx) {
    if (target == 0) {
        result.add(new ArrayList<>(list1));
        return;
    }
    if (target < 0) {
        return;
    }
    for (int i = idx; i < nums.length; i++) {
        list1.add(nums[i]);
        backtrack(list1, result, nums, target - nums[i], i);
        list1.remove(list1.size() - 1);
    }
}
```

In this function:
- `list1` represents the current combination being explored.
- `result` is the list of all valid combinations found so far.
- `nums` is the array of candidate numbers.
- `target` is the remaining sum needed to reach the target.
- `idx` is the current index in the `nums` array.
- The base cases are:
  - If `target` becomes zero, it means we've found a valid combination, so we add it to the `result` list.
  - If `target` becomes negative, we stop exploring the current branch and backtrack.
- The recursive case:
  - Iterate through the `nums` array starting from `idx`.
  - For each candidate, add it to the current combination `list1`.
  - Recursively call `backtrack` with the updated `target` (reduced by the added candidate's value) and the same index `i` (since we can use the same candidate multiple times).
  - After the recursive call, remove the last added candidate from `list1` to backtrack and explore other branches.

### Code
```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(new ArrayList<>(), result, candidates, target, 0);
    return result;
}

public static void backtrack(List<Integer> list1, List<List<Integer>> result, int[] nums, int target, int idx) {
    if (target == 0) {
        result.add(new ArrayList<>(list1));
        return;
    }
    if (target < 0) {
        return;
    }
    for (int i = idx; i < nums.length; i++) {
        list1.add(nums[i]);
        backtrack(list1, result, nums, target - nums[i], i);
        list1.remove(list1.size() - 1);
    }
}
```

### Complexity
- Time: O(N^(T/M) + 1), where N is the length of the candidates array, T is the target sum, and M is the minimum value in the candidates array. This is because in the worst case, we might have to explore all possible combinations of candidates that sum up to the target.
- Space: O(T/M), which is the maximum depth of the recursion call stack. This is because we need to store the current combination being explored, which can have at most T/M elements.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the candidates array contains duplicates? How would you modify the solution to handle duplicates?
   - To handle duplicates, we can sort the candidates array and skip duplicate elements in the backtracking process.
2. What if the candidates array is very large, and we want to optimize the solution for memory usage?
   - To optimize memory usage, we can use an iterative approach instead of recursion, which would reduce the memory needed for the call stack. We can also use a more efficient data structure, such as a queue, to store the combinations to be explored.