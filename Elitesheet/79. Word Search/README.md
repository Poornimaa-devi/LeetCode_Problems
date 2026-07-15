<h2><a href="https://leetcode.com/problems/word-search">79. Word Search</a></h2>

<p>Given an <code>m x n</code> grid of characters <code>board</code> and a string <code>word</code>, return <code>true</code> <em>if</em> <code>word</code> <em>exists in the grid</em>.</p>

<p>The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n = board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 6</code></li>
	<li><code>1 &lt;= word.length &lt;= 15</code></li>
	<li><code>board</code> and <code>word</code> consists of only lowercase and uppercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you use search pruning to make your solution faster with a larger <code>board</code>?</p>


---

# 🛍️ Word-Search | Explained

## Approach 1 (Optimized Depth-First Search)
### Intuition
The core idea behind this approach is to traverse the 2D grid (`board`) using a depth-first search (DFS) to find the target word. Imagine you are trying to find a path in a maze, where each step can be up, down, left, or right. If you reach a dead end, you backtrack and try a different path. In this case, the "maze" is the grid of characters, and the "path" is the sequence of characters that matches the target word. This approach works because it exhaustively explores all possible paths from each starting point.

### Approach
The algorithmic breakdown is as follows:
1. Start by iterating through each cell in the grid to find potential starting points for the word.
2. For each starting point, initialize a DFS traversal.
3. During the DFS traversal, check if the current cell matches the next character in the target word.
4. If it matches, mark the cell as visited and recursively explore neighboring cells (up, down, left, right).
5. If the recursive call returns `true`, indicating that the word has been found, return `true`.
6. If the recursive call returns `false`, reset the visited mark and try a different path.
7. If all paths have been explored and the word has not been found, return `false`.

### Detailed Code Analysis
Let's dive into the code block. The `exist` function takes a 2D grid `board` and a target word `word` as input. It initializes the number of rows and columns in the grid and iterates through each cell to find potential starting points for the word.

The `dfs` function is a recursive function that takes the current position `(i, j)`, the grid dimensions `(rows, cols)`, the grid itself `board`, the current result string `res`, the current index in the word `idx`, the target word `word`, and a visited matrix `visited`. 

Here's a key excerpt:
```rust
if board[i as usize][j as usize] != word.chars().nth(idx).unwrap() {
    // println!(returning false
);
    return false;
}
```
This line checks if the current cell matches the next character in the target word. If it doesn't match, the function immediately returns `false`.

The recursive calls are made for each neighboring cell (up, down, left, right):
```rust
let result = Self::dfs(i - 1, j, rows, cols, board, res.clone(), idx + 1, word, visited) || 
             Self::dfs(i + 1, j, rows, cols, board, res.clone(), idx + 1, word, visited) ||
             Self::dfs(i, j - 1, rows, cols, board, res.clone(), idx + 1, word, visited) || 
             Self::dfs(i, j + 1, rows, cols, board, res.clone(), idx + 1, word, visited);
```
The `clone` method is used to create a copy of the current result string `res` for each recursive call.

### Code
```rust
impl Solution {
    fn dfs(
        i: i32,
        j: i32,
        rows: i32,
        cols: i32,
        board: &Vec<Vec<char>>,
        mut res: String,
        idx: usize,
        word: &str,
        visited: &mut Vec<Vec<bool>>
    ) -> bool {
        // boundary check
        if i < 0 || j < 0 || i == rows || j == cols {
            return false;
        }

        // visited check
        if visited[i as usize][j as usize] {
            return false;
        }
        
        // character match check
        if idx < word.len() && board[i as usize][j as usize] != word.chars().nth(idx).unwrap() {
            return false;
        }

        res.push(board[i as usize][j as usize]);
        visited[i as usize][j as usize] = true;

        // word found check
        if res == word {
            return true;
        }

        let result = Self::dfs(i - 1, j, rows, cols, board, res.clone(), idx + 1, word, visited) || 
                     Self::dfs(i + 1, j, rows, cols, board, res.clone(), idx + 1, word, visited) ||
                     Self::dfs(i, j - 1, rows, cols, board, res.clone(), idx + 1, word, visited) || 
                     Self::dfs(i, j + 1, rows, cols, board, res.clone(), idx + 1, word, visited);

        if !result {
            visited[i as usize][j as usize] = false;
        }

        result
    }

    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        let first_char = word.chars().next().unwrap();

        let rows = board.len();
        let cols = board[0].len();

        for i in 0..rows {
            for j in 0..cols {
                let mut visited = vec![vec![false; cols]; rows];
                if board[i][j] == first_char && Self::dfs(
                    i as i32, 
                    j as i32, 
                    rows as i32,
                    cols as i32, 
                    &board, 
                    String::new(),
                    0,
                    &word, 
                    &mut visited
                ) {
                    return true;
                }
            }
        }

        false
    }
}
```

### Complexity
- Time: O(N \* M \* 4^L), where N is the number of rows, M is the number of columns, and L is the length of the word. This is because in the worst case, we need to explore all 4 directions (up, down, left, right) for each cell in the grid, and the depth of the recursion is at most L.
- Space: O(N \* M), which is the space required to store the visited matrix. The recursion stack also requires at most O(L) space, but since L is typically much smaller than N \* M, it's dominated by the space required for the visited matrix.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **Optimization:** How can you optimize the solution to reduce the number of recursive calls?
   Answer: One possible optimization is to prune the search space by only exploring cells that match the next character in the word. This can be achieved by maintaining a separate data structure to store the positions of each character in the grid.
2. **Edge Case:** What happens if the input grid is empty, or the word is empty?
   Answer: The solution should handle these edge cases by returning an empty result or false, depending on the specific requirements. For example, if the input grid is empty, the function should return false, since it's not possible to find a word in an empty grid.