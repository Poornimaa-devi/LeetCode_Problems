1class Solution {
2    public int totalNumbers(int[] digits) {
3        Set<Integer> s = new HashSet<>();
4        int n = digits.length;
5        for(int i=0;i<n;i++){
6            for(int j=0;j<n;j++){
7                for(int k=0;k<n;k++){
8                    if(i==j || i==k || j==k) continue;
9                    if(digits[i]==0) continue;
10                    if(digits[k]%2!=0) continue;
11                    int num = digits[i]*100 + digits[j]*10 + digits[k];
12                    s.add(num); 
13                }
14            }
15        }
16        return s.size();
17    }
18}