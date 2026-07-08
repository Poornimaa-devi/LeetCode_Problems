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

## Approach 1: Backtracking
### Intuition
Imagine you're shopping and you have a budget (target) that you need to spend on a set of items (candidates) with varying prices. The goal is to find all possible combinations of items that sum up to your budget. This approach works by exploring all possible combinations recursively, backtracking when a combination exceeds the budget, and keeping track of valid combinations.

### Approach
The algorithm starts with an empty combination and a full budget. It then iterates through each item, adds it to the current combination, and recursively explores all possible combinations with the updated budget. If the budget is exhausted (target reaches 0), the current combination is valid and added to the result. If the budget is exceeded (target becomes negative), the current combination is invalid and the algorithm backtracks by removing the last added item.

### Detailed Code Analysis
Let's dive into the code block:
```java
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> result = new ArrayList<>();
4        backtrack(new ArrayList<>(),result,candidates,target,0);
5        return result;
6    }
7    public static void backtrack(List<Integer> list1,List<List<Integer>> result,int[] nums,int target,int idx){
8        if(target==0){
9            result.add(new ArrayList<>(list1));
10            return;
11        }
12        if(target<0){
13            return;
14        }
15        for(int i=idx;i<nums.length;i++){
16            list1.add(nums[i]);
17            backtrack(list1,result,nums,target-nums[i],i);
18            list1.remove(list1.size()-1);
19        }
20    }
21}
```
Here's what the code does:
- Line 3: An empty list `result` is initialized to store all valid combinations.
- Line 4: The `backtrack` function is called with an empty list `list1`, the `result` list, the `candidates` array, the `target`, and an index `idx` set to 0.
- In the `backtrack` function:
  - Line 8-10: If the target reaches 0, a valid combination is found, and a copy of `list1` is added to the `result`.
  - Line 12-13: If the target becomes negative, the current combination is invalid, and the function returns (backtracks).
  - Line 15-19: The function iterates through each item in the `candidates` array starting from the current index `idx`. For each item:
    - Line 16: The item is added to the current combination `list1`.
    - Line 17: The `backtrack` function is called recursively with the updated combination, target, and index.
    - Line 18: After the recursive call returns, the last added item is removed from the combination (backtracking).

### Code
```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(new ArrayList<>(),result,candidates,target,0);
    return result;
}

public static void backtrack(List<Integer> list1,List<List<Integer>> result,int[] nums,int target,int idx){
    if(target==0){
        result.add(new ArrayList<>(list1));
        return;
    }
    if(target<0){
        return;
    }
    for(int i=idx;i<nums.length;i++){
        list1.add(nums[i]);
        backtrack(list1,result,nums,target-nums[i],i);
        list1.remove(list1.size()-1);
    }
}
```
### Complexity
- Time: The time complexity is O(N^(T/M + 1)), where N is the length of the candidates array, T is the target sum, and M is the minimum value in the candidates array. This is because in the worst-case scenario, the algorithm explores all possible combinations of items that sum up to the target.
- Space: The space complexity is O(T/M), which is the maximum recursion depth. This is because the algorithm uses a recursive approach to explore all possible combinations, and the maximum recursion depth is determined by the size of the target sum and the minimum value in the candidates array.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
- What if the candidates array contains duplicates? How would you modify the algorithm to handle duplicates?
  - Answer: To handle duplicates, you can sort the candidates array and skip duplicates during the iteration.
- What if the target sum is very large? How would you optimize the algorithm to handle large target sums?
  - Answer: To handle large target sums, you can use a more efficient data structure, such as a dynamic programming table, to store and reuse intermediate results.