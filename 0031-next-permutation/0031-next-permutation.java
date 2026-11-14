class Solution {
    public void nextPermutation(int[] nums) {
        int i=-1;
        int j=-1;
        int n=nums.length;

        for(int x=n-2;x>=0;x--){
            if(nums[x]<nums[x+1]){
                i=x;
                break;
            }
        }

        if(i>-1){
            for(int x=n-1;x>=0;x--){
                if(nums[x]>nums[i]){
                    j=x;
                    break;
                }
            }
        }

        

        

        if(i>-1){
            swap(i, j, nums);
            reverse(i+1, nums);
        }
        else{
            reverse(0, nums);
        }



    }
    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int start, int[] nums) {
        int end = nums.length - 1;

        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
}