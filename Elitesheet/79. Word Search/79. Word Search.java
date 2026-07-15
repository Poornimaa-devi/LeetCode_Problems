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
        // println!(i: {i}, j: {j});
        if i < 0 || j < 0 || i == rows || j == cols {
            // println!(returning false
);
            return false;
        }

        // println!(visited[{i}][{j}]: {}, visited[i as usize][j as usize]);
        if visited[i as usize][j as usize] {
            // println!(returning false
);
            return false;
        }
        
        // println!(character on the board: {}	character of word currently: {}, board[i as usize][j as usize], word.chars().nth(idx).unwrap());
        if idx < word.len() && board[i as usize][j as usize] != word.chars().nth(idx).unwrap() {
            // println!(returning false
);
            return false;
        }

        res.push(board[i as usize][j as usize]);
        // println!(res: {res});
        visited[i as usize][j as usize] = true;

        if res == word {
            // println!(returning true
);
            return true;
        }

        let result = Self::dfs(i - 1, j, rows, cols, board, res.clone(), idx + 1, word, visited) || Self::dfs(i + 1, j, rows, cols, board, res.clone(), idx + 1, word, visited) ||
        Self::dfs(i, j - 1, rows, cols, board, res.clone(), idx + 1, word, visited) || Self::dfs(i, j + 1, rows, cols, board, res.clone(), idx + 1, word, visited);

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