class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n=Math.min(prices.length, discounts.length);
        double ans=0;
        

        for(int i=0;i<n;i++){
            int discountindex=discounts.length-i-1;
            int priceindex=prices.length-i-1;

            ans+=(prices[priceindex] * (100.0 - discounts[discountindex])) / 100.0;
        }


        for(int i=0;i<prices.length-n;i++){
            ans+=prices[i];
        }
        
        return ans;
    }
}