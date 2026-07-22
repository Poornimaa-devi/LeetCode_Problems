<h2><a href="https://leetcode.com/problems/fruit-into-baskets">904. Fruit Into Baskets</a></h2>

<p>You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array <code>fruits</code> where <code>fruits[i]</code> is the <strong>type</strong> of fruit the <code>i<sup>th</sup></code> tree produces.</p>

<p>You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:</p>

<ul>
	<li>You only have <strong>two</strong> baskets, and each basket can only hold a <strong>single type</strong> of fruit. There is no limit on the amount of fruit each basket can hold.</li>
	<li>Starting from any tree of your choice, you must pick <strong>exactly one fruit</strong> from <strong>every</strong> tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.</li>
	<li>Once you reach a tree with fruit that cannot fit in your baskets, you must stop.</li>
</ul>

<p>Given the integer array <code>fruits</code>, return <em>the <strong>maximum</strong> number of fruits you can pick</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> fruits = [<u>1,2,1</u>]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can pick from all 3 trees.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> fruits = [0,<u>1,2,2</u>]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> fruits = [1,<u>2,3,2,2</u>]
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= fruits.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= fruits[i] &lt; fruits.length</code></li>
</ul>


---

# 🛍️ Fruit-Into-Baskets | Explained
## Approach 1: Sliding Window with HashMap
### Intuition
The intuition behind this approach is to maintain a sliding window over the array of fruits. The window represents the current selection of fruits that can be picked. We use a HashMap to keep track of the count of each type of fruit within the window. The window expands to the right by adding new fruits and contracts from the left by removing fruits that are no longer within the window. This approach ensures that we always have at most two types of fruits in the basket.

### Algorithm Visualized
```mermaid
graph LR
    A[Fruit Array] -->|Sliding Window|> B[Window with HashMap]
    B -->|Expand Right|> C[Add New Fruit to Window]
    B -->|Contract Left|> D[Remove Fruit from Window]
    C -->|Update HashMap|> B
    D -->|Update HashMap|> B
```

### Approach
1. Initialize an empty HashMap to store the count of each type of fruit.
2. Initialize two pointers, `left` and `right`, to represent the start and end of the sliding window.
3. Iterate through the array of fruits using the `right` pointer. For each fruit, increment its count in the HashMap.
4. If the size of the HashMap exceeds 2, it means we have more than two types of fruits in the window. In this case, we contract the window from the left by moving the `left` pointer to the right.
5. When contracting the window, decrement the count of the fruit at the `left` pointer in the HashMap. If the count becomes 0, remove the fruit from the HashMap.
6. Continue expanding and contracting the window until we have processed all fruits.
7. Keep track of the maximum size of the window, which represents the maximum number of fruits that can be picked.

### Detailed Code Analysis
The code initializes a HashMap `map` to store the count of each type of fruit and two pointers `left` and `right` to represent the sliding window. The `right` pointer iterates through the array of fruits, and for each fruit, its count is incremented in the HashMap using `map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1)`. The `getOrDefault` method returns the current count of the fruit if it exists in the HashMap; otherwise, it returns 0.

When the size of the HashMap exceeds 2, the window contracts from the left. The count of the fruit at the `left` pointer is decremented using `map.put(fruits[left], map.get(fruits[left]) - 1)`. If the count becomes 0, the fruit is removed from the HashMap using `map.remove(fruits[left])`. The `left` pointer is then moved to the right.

The maximum size of the window is kept track of using the `max` variable, which is updated whenever the size of the window exceeds the current maximum.

### Code
```java
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
```

### Complexity
- **Time:** O(n), where n is the number of fruits. We iterate through the array of fruits once, and the operations within the loop (HashMap updates and pointer movements) take constant time.
- **Space:** O(1), since the size of the HashMap is bounded by the number of unique fruits, which is at most 2. However, in the worst case, if all fruits are unique, the space complexity becomes O(n). But for the given problem, we can consider it as O(1) because the number of unique fruits is limited to 2.