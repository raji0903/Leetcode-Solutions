class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int res=0;
        int l=0, r= n-1;
        while(l<r){
            int area = (r-l)*Math.min(height[r],height[l]);
            res= Math.max(res,area);
            if(height[r]<height[l]){
                r--;
            }else{
                l++;
            }
        }
        return res;
        
    }
}