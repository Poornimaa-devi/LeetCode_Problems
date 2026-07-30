1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        
4        int totgas=0,totcost=0;
5        for(int i=0;i<gas.length;i++){
6            totgas += gas[i];
7            totcost += cost[i];
8        }
9        if(totgas<totcost){
10            return -1;
11        }
12        int currentgas=0;
13        int start=0;
14        for(int i=0;i<gas.length;i++){
15            currentgas += gas[i]-cost[i];
16            if(currentgas<0){
17                currentgas=0;
18                start=i+1;
19            }
20        }
21        return start;    
22    }
23}