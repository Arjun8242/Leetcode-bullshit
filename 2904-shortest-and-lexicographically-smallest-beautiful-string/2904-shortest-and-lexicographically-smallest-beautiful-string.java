class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();

        int[] freq=new int[n];

        for(int i=0;i<n;i++){
            freq[i]=(i>0?freq[i-1]:0);

            if(s.charAt(i)=='1') freq[i]++;
        }

        String ans="";
        int minlen=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int ones=freq[j]-(i>0?freq[i-1]:0);

                if(ones==k){
                    int len=j-i+1;
                    String sub=s.substring(i, j+1);

                    if(len<minlen){
                        minlen=len;
                        ans=sub;
                    }

                    else if(len==minlen && sub.compareTo(ans)<0){
                        ans=sub;
                    }
                }
            }
        }
        return ans;
    }
}