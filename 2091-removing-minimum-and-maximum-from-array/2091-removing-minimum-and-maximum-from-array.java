class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minind=-1;
        int maxind=-1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i]>=max){
                max=nums[i];
                maxind=i;
            }
            if(nums[i]<=min){
                min=nums[i];
                minind=i;
            }
        }
        
        int fromfront=Math.max(maxind, minind)+1;
        int fromback=n-Math.min(maxind, minind);
        int mid = Math.min(
    Math.min(minind, maxind) + 1 + n - Math.max(minind, maxind),
    Math.max(minind, maxind) + 1 + n - Math.min(minind, maxind));

    return Math.min(fromfront, Math.min(fromback, mid));


    }
}