class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int posof0=-1;
        int ans=Integer.MAX_VALUE;
        

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                posof0=i;
                break;
            }
        }

        if(ascendingrot(nums)){
            ans=Math.min(ans, Math.min(posof0, n-posof0+2));
        }

        if(descendingrot(nums)){
            int costofrev=1+(n-1-posof0);
            int costofrot=1+((posof0+1)%n);
            ans=Math.min(ans, Math.min(costofrev, costofrot));
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public boolean ascendingrot(int[] nums){
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[(i+1)%n]!=(nums[i]+1)%n){
                return false;
            }
        }
        return true;
    }

    public boolean descendingrot(int[] nums){
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[(i+1)%n]!=(nums[i]-1+n)%n){
                return false;
            }
        }
        return true;
    }
}