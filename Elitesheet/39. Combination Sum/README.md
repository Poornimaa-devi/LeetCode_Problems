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
Imagine you're at a store trying to buy items with a limited budget. You have different types of items, each with its own price, and you want to find all combinations of items that add up to your budget. This approach works by exploring all possible combinations of items (or numbers in this case) and backtracking when the total exceeds the target.

### Approach
The algorithm starts by initializing an empty list to store the current combination and another list to store all valid combinations. It then calls a helper function `backtrack` which explores all possible combinations recursively. The `backtrack` function checks if the remaining target is zero (meaning a valid combination is found), or if it's negative (meaning the current combination exceeds the target). If it's neither, it continues exploring all possible combinations by adding each number in the candidates list to the current combination.

### Detailed Code Analysis
Let's break down the code:
* `List<List<Integer>> result = new ArrayList<>();` initializes an empty list to store all valid combinations.
* `backtrack(new ArrayList<>(), result, candidates, target, 0);` calls the helper function to start exploring combinations.
* `if(target==0){ result.add(new ArrayList<>(list1)); return; }` checks if a valid combination is found and adds it to the result list.
* `if(target<0){ return; }` checks if the current combination exceeds the target and backtracks.
* `for(int i=idx;i<nums.length;i++){...}` explores all possible combinations by adding each number in the candidates list to the current combination.
* `list1.add(nums[i]);` adds the current number to the current combination.
* `backtrack(list1, result, nums, target-nums[i], i);` recursively calls the `backtrack` function with the updated current combination and target.
* `list1.remove(list1.size()-1);` removes the last added number from the current combination (backtracking).

### Code
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, candidates, target, 0);
        return result;
    }
    public static void backtrack(List<Integer> list1, List<List<Integer>> result, int[] nums, int target, int idx){
        if(target==0){
            result.add(new ArrayList<>(list1));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            list1.add(nums[i]);
            backtrack(list1, result, nums, target-nums[i], i);
            list1.remove(list1.size()-1);
        }
    }
}
```

### Complexity
- Time: The time complexity is O(N^(T/M + 1)) where N is the number of candidates, T is the target, and M is the minimum value among the candidates. This is because in the worst case, we explore all possible combinations of numbers.
- Space: The space complexity is O(T/M) due to the recursion stack and the space needed to store the current combination.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions and brief answers:
1. **What if the input array contains duplicates?** The current solution will treat duplicates as distinct numbers. To handle duplicates, we need to sort the input array and skip duplicates when exploring combinations.
2. **Can we optimize the solution to handle large inputs?** Yes, we can optimize the solution by using a more efficient data structure, such as a `HashSet` to store the current combination, or by using dynamic programming to memoize intermediate results. However, these optimizations may not be necessary for small inputs.