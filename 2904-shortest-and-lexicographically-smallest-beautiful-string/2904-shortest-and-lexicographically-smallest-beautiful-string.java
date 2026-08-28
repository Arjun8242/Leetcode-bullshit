class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int ones=0;
        String ans="";
        int minlen=Integer.MAX_VALUE;
        int left=0;

        for(int right=0;right<n;right++){
            if(s.charAt(right)=='1') ones++;

            while(ones>k){
                if(s.charAt(left)=='1'){
                    ones--;
                }
                left++;
            }

            if(ones==k){

                while(s.charAt(left)=='0'){
                    left++;
                }

                    int len=right-left+1;
                    String sub=s.substring(left, right+1);

                    if(len<minlen){
                        minlen=len;
                        ans=sub;
                    }

                    else if(len==minlen && sub.compareTo(ans)<0){
                        ans=sub;
                    }
            }
        }

    
        return ans;
    }
}