class Solution {
    public int maxProduct(int n) {
        List<Integer> digits=new ArrayList<>();

        while(n>0){
            int rem=n%10;
            digits.add(rem);
            n/=10;
        }

        Collections.sort(digits);

        return digits.get(digits.size()-1)*digits.get(digits.size()-2);
    }
}