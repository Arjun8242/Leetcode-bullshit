class Solution {
    int maxlen=1;
    int start=0;

    public String longestPalindrome(String s) {
        int n=s.length();

        for(int i=0;i<n-1;i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }

        return s.substring(start, start+maxlen);
    }

    public void expand(String s, int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        int len=right-left-1;//bcz when while ends left and right both have moved one step outside the palindrome means palindrome =0,2 but left, right=-1, 3

        if(len>maxlen){
            maxlen=len;
            start=left+1;
        }

    }
}