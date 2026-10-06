class Solution {
    public int minAddToMakeValid(String s) {
        int opening=0;
        int extraopening=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                opening++;
            }
            else if(s.charAt(i)==')' && opening>0){
                opening--;
            }
            else{
                extraopening++;
            }
        }

        return opening+extraopening;
    }
}