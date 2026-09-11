1class Solution {
2    class Cell{
3        int row=0;
4        int col=0;
5        int height=0;
6        Cell(int row,int col,int height){
7            this.row=row;
8            this.col=col;
9            this.height=height;
10        }
11    }
12    public int trapRainWater(int[][] heightMap) {
13        int m=heightMap.length;
14        int n=heightMap[0].length;
15        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)-> a.height-b.height);
16        boolean[][] visited = new boolean[m][n];
17        for(int i=0;i<m;i++){
18            for(int j=0;j<n;j++){
19                if(i==0 || j==0 || i==m-1 || j==n-1){
20                pq.offer(new Cell(i,j,heightMap[i][j]));
21                visited[i][j]=true;
22                }
23            }
24        }
25        int water=0;
26        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
27        while(!pq.isEmpty()){
28            Cell current = pq.poll();
29            for(int[] dir : directions){
30                 int nr = current.row + dir[0];
31                 int nc = current.col + dir[1];
32                 if(nr<0 || nc<0 || nr >=m || nc>=n || visited[nr][nc]) continue;
33                 visited[nr][nc]=true;
34                 int neighbour = heightMap[nr][nc];
35                 water+=Math.max(0,current.height - neighbour);
36                 int newheight = Math.max(current.height,neighbour);
37                 pq.offer(new Cell(nr,nc,newheight));
38            }
39        }
40        return water;
41    }
42}