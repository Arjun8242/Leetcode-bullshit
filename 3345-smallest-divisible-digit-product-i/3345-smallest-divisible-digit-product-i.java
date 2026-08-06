class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int pdt=1;
            int num=n;
            while(num>0){
                pdt*=num%10;
                num/=10;
            }
            if(pdt%t==0) return n;
            n++;
        }
    }
}