1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3        List<List<Integer>> result = new ArrayList<>();
4        Arrays.sort(candidates);
5        backtrack(candidates,target,0,result,new ArrayList<>());
6        return result;
7    }
8    public static void backtrack(int[] candidates,int target,int index,List<List<Integer>> result,List<Integer> l1){
9        if(target==0) {
10            result.add(new ArrayList<>(l1));
11            return;
12        }if(target<0){
13            return;
14        }
15        for(int i=index;i<candidates.length;i++){
16            if(candidates[i]>target){
17                break;
18            }
19            if(i>index && candidates[i]==candidates[i-1]) continue;
20            l1.add(candidates[i]);
21            backtrack(candidates,target-candidates[i],i+1,result,l1);
22            l1.remove(l1.size()-1);
23        }
24    }
25}