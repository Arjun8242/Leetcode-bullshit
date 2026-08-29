class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=max(piles);
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            long hours=calculate(piles, mid);

            if(hours<=h){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public long calculate(int[] piles, int x){
        long hour=0;
    
        for(int y:piles){
            hour+= (int)Math.ceil((double)y / x);
        }
        return hour;
    }
    public int max(int[] piles){
        int max=Integer.MIN_VALUE;

        for(int x:piles){
            max=Math.max(max, x);
        }
        return max;
    }
}