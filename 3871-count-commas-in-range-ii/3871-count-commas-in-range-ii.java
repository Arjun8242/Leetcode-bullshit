class Solution {
    public long countCommas(long n) {
        long count=0;
        long start=1000;
        int comma=1;

        if(n<999) return 0;
        
        while(start<=n){
            long end=start*1000-1;
            if(n<=end){
                count += comma * (n - start + 1);
                break;
            }
            count+=comma*(end-start+1);

            start*=1000;
            comma++;
            
        }
        return count;
        
    }
}