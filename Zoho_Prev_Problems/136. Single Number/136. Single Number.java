Arrays.sort(nums);
if(nums.length==1){
    return nums[0];
}
for(int i=0;i<nums.length-1;i++){
    for(int j=i+1;j<i+2;j++){
        
        if(i==nums.length-2){
          if(nums[i]!=nums[j]){
              return nums[j];
          }else{
              continue;
          }
        }else if(i==0){
            if(nums[i]!=nums[j]){
              return nums[i];
          }else{
              continue;
          }
        }
        if(nums[i]==nums[j] || nums[j]==nums[j+1]){
            continue;
        }else{
         return nums[j];
        }
    }
}     