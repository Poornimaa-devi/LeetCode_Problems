1class Solution {
2    public void setZeroes(int[][] matrix) {
3        int rowCount = matrix.length;
4        int colCount = matrix[0].length;
5        boolean[] rows = new boolean[rowCount];
6        boolean[] cols = new boolean[colCount];
7        boolean isEmpty = true;      
8        
9        for (int i = 0; i < rowCount; i++)
10            for (int j = 0; j < colCount; j++)
11                if (matrix[i][j] == 0) {
12                    rows[i] = true;
13                    cols[j] = true;
14                    isEmpty = false;
15                }
16            
17        if (!isEmpty)
18            for (int i = 0; i < rowCount; i++)
19                for (int j = 0; j < colCount; j++)
20                    if (rows[i] || cols[j])
21                        matrix[i][j] = 0;
22    }
23}