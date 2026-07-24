<h2><a href="https://leetcode.com/problems/word-search-ii">212. Word Search II</a></h2>

<p>Given an <code>m x n</code> <code>board</code>&nbsp;of characters and a list of strings <code>words</code>, return <em>all words on the board</em>.</p>

<p>Each word must be constructed from letters of sequentially adjacent cells, where <strong>adjacent cells</strong> are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/07/search1.jpg" style="width: 322px; height: 322px;">
<pre><strong>Input:</strong> board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
<strong>Output:</strong> ["eat","oath"]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/07/search2.jpg" style="width: 162px; height: 162px;">
<pre><strong>Input:</strong> board = [["a","b"],["c","d"]], words = ["abcb"]
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n == board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 12</code></li>
	<li><code>board[i][j]</code> is a lowercase English letter.</li>
	<li><code>1 &lt;= words.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
	<li>All the strings of <code>words</code> are unique.</li>
</ul>


---

# 🛍️ Word-Search-II | Explained

## Approach 1: Trie-Based Depth-First Search
### Intuition
The Word-Search-II problem can be solved using a Trie-based depth-first search approach. The core idea is to first build a Trie data structure containing all the words in the input array. Then, for each cell in the grid, perform a depth-first search to explore all possible word paths. This approach works because the Trie allows for efficient word matching, and the depth-first search enables us to explore all possible paths from each cell.

### Algorithm Visualized
```mermaid
graph LR
    A[Root] -->|a|> B(a)
    A -->|b|> C(b)
    B -->|b|> D(ab)
    C -->|a|> E(ba)
    D -->|#|> E(end of word)
    E -->|#|> F(end of word)
```
### Approach
The algorithm can be broken down into the following steps:
1. Build a Trie containing all the words in the input array.
2. For each cell in the grid, perform a depth-first search to explore all possible word paths.
3. During the depth-first search, use the Trie to efficiently match words and prune branches that cannot lead to a valid word.
4. When a valid word is found, add it to the result list and mark the corresponding Trie node as visited to avoid duplicates.

### Detailed Code Analysis
The code defines a TrieNode class to represent each node in the Trie. Each TrieNode has an array of children (one for each letter in the alphabet) and a word field to store the word associated with the node.

The `insert` method is used to add words to the Trie. It iterates through each character in the word, creating new Trie nodes as necessary, and finally sets the word field of the last node to the input word.

The `findWords` method is the main entry point of the algorithm. It first builds the Trie by inserting all the words in the input array. Then, for each cell in the grid, it calls the `dfs` method to perform a depth-first search.

The `dfs` method takes a cell's coordinates, the current Trie node, and a result list as input. It first checks if the cell is out of bounds or if the current Trie node has no child corresponding to the cell's letter. If either condition is true, it returns immediately.

Otherwise, it recursively calls itself for all neighboring cells, using the Trie to prune branches that cannot lead to a valid word. When a valid word is found, it adds the word to the result list and marks the corresponding Trie node as visited by setting its word field to null.

### Code
```java
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for(String s : words){
            insert(s);
        }
        List<String> ans = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(board,i,j,root,ans);
            }
        }
        return ans;
    }

    private void dfs(char[][] board,int r,int c,TrieNode root,List<String> ans){
        if(r<0 || c<0 || r>=board.length || c >= board[0].length) return;
        char ch = board[r][c];
        if(ch == '#') return;
        TrieNode next = root.children[ch-'a'];
        if(next == null) return;
        if(next.word!=null){
            ans.add(next.word);
            next.word = null;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        dfs(board,r-1,c,next,ans);
        dfs(board,r,c-1,next,ans);
        dfs(board,r+1,c,next,ans);
        dfs(board,r,c+1,next,ans);

        board[r][c]=temp;
    }

    private void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx]==null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.word = word;
    }
}
```
### Complexity
- **Time:** O(N \* M \* 4^L), where N is the number of rows in the grid, M is the number of columns, and L is the maximum length of a word. The 4^L term comes from the fact that each cell can have up to 4 neighboring cells.
- **Space:** O(N \* M + W), where W is the total number of words. The N \* M term comes from the grid, and the W term comes from the Trie and the result list.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. How would you handle the case where the same word appears multiple times in the grid?
   Answer: To handle this case, we can use a HashSet to store the words found so far and check if a word is already in the set before adding it to the result list.

2. How would you optimize the algorithm for large grids and long words?
   Answer: To optimize the algorithm, we can use a more efficient data structure such as a HashMap to store the words in the Trie, and use iterative deepening depth-first search (IDDFS) to explore the grid. We can also use a pruning technique to eliminate branches that cannot lead to a valid word.