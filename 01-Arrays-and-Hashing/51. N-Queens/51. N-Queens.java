1class Solution {
2    public static List<List<String>> queens(char matrix[][],int n,int r,List<List<String>> result){
3        List<String> ql = new ArrayList<>();
4        if(r==n) {
5           result.add(construct(matrix)); 
6           return result;             
7        }
8        for(int c=0;c<n;c++){
9            if(safe(matrix,n,r,c)==1){
10                matrix[r][c]='Q';
11                queens(matrix,n,r+1,result);
12                matrix[r][c]='.';
13            }
14        }
15       return result;
16    }
17    public static int safe(char matrix[][],int n,int r,int c){
18        for(int i=r;i>=0;i--){
19            if(matrix[i][c]=='Q') return 0;
20        }
21        for(int i=r,j=c;(i>=0 && j>=0);i--,j--){
22            if(matrix[i][j]=='Q') return 0;
23        }
24        for(int i=r,j=c;i>=0 && j<n;i--,j++){
25            if(matrix[i][j]=='Q') return 0;
26        }
27        return 1;
28    }
29
30    public static List<String> construct(char[][] matrix){
31        List<String> board = new ArrayList<>();
32        for(int i=0;i<matrix.length;i++){
33            String row = new String(matrix[i]);
34            board.add(row);
35        }
36        return board;
37    }
38    public List<List<String>> solveNQueens(int n) {
39        int r = n;
40        int c = n;
41        char matrix[][] = new char[r][c];
42        for(int i=0;i<r;i++){
43            for(int j=0;j<c;j++){
44                matrix[i][j]='.';
45            }
46        }
47        List<List<String>> result = new ArrayList<>();
48        return queens(matrix,n,0,result);
49        
50    }
51}