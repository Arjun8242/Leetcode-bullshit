class Solution {
    public boolean sumGame(String num) {
        int leftquesmark=0;
        int leftsum=0;
        int rightquesmark=0;
        int rightsum=0;
        int n=num.length();

        for(int i=0;i<n/2;i++){
            if(num.charAt(i)=='?') leftquesmark++;
            else leftsum+=num.charAt(i)-'0';
        }
        for(int i=n/2;i<n;i++){
            if(num.charAt(i)=='?') rightquesmark++;
            else rightsum+=num.charAt(i)-'0';
        }
        
        if(leftquesmark+rightquesmark==0){
            if(rightsum==leftsum) return false;
            else return true;
        }

        if((leftquesmark+rightquesmark)%2==1) return true;

        if((leftquesmark+rightquesmark)%2==0){
            if(leftquesmark==rightquesmark){
                return leftsum!=rightsum;
            }
            else{
                int diff=rightsum-leftsum;
                int questiondiff=leftquesmark-rightquesmark;

                return 2*diff!=9*questiondiff;
            } 
        }

        return false;
    }
}