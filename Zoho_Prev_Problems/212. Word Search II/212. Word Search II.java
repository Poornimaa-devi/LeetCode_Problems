1class Solution {
2    class TrieNode {
3        TrieNode[] children = new TrieNode[26];
4        String word;
5    }
6
7    TrieNode root = new TrieNode();
8
9    public List<String> findWords(char[][] board, String[] words) {
10        for(String s : words){
11            insert(s);
12        }
13        List<String> ans = new ArrayList<>();
14        int rows = board.length;
15        int cols = board[0].length;
16        for(int i=0;i<rows;i++){
17            for(int j=0;j<cols;j++){
18                dfs(board,i,j,root,ans);
19            }
20        }
21        return ans;
22    }
23
24    private void dfs(char[][] board,int r,int c,TrieNode root,List<String> ans){
25        if(r<0 || c<0 || r>=board.length || c >= board[0].length) return;
26        char ch = board[r][c];
27        if(ch == '#') return;
28        TrieNode next = root.children[ch-'a'];
29        if(next == null) return;
30        if(next.word!=null){
31            ans.add(next.word);
32            next.word = null;
33        }
34        char temp = board[r][c];
35        board[r][c] = '#';
36        dfs(board,r-1,c,next,ans);
37        dfs(board,r,c-1,next,ans);
38        dfs(board,r+1,c,next,ans);
39        dfs(board,r,c+1,next,ans);
40
41        board[r][c]=temp;
42    }
43
44    private void insert(String word){
45        TrieNode node = root;
46        for(char ch : word.toCharArray()){
47            int idx = ch - 'a';
48            if(node.children[idx]==null){
49                node.children[idx] = new TrieNode();
50            }
51            node = node.children[idx];
52        }
53         node.word = word;
54    }
55}