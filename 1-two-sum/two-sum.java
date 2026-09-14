/* class Solution { 
    public int[] twoSum(int[] nums, int target) {
         for(int i=0;i<nums.length;i++){
             for(int j=i+1;j<nums.length;j++){ 
                if(nums[i]+nums[j]==target){ 
                    return new int[]{i,j}; 
            } 
        } 
        
    } 
    return new int[]{}; 
    
}
} */

/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i =0;i<nums.length;i++){
        int num=nums[i];
        int complement=target - num;
        if(map.containsKey(complement)){
            return new int[]{
                map.get(complement),i
            };   
        }
        map.put(num,i);
    }
    return new int[] {};  
    }
}
*/
class Solution{
    public int [] twoSum(int [] nums,int target){
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
        int different = target - nums[i];
        while(map.containsKey(different)){
           return new int[]{map.get(different),i};
        }
        map.put(nums[i],i);
        }
        return new int[]{};
    }
}