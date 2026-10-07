class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;


        for(int i=0;i<n;i++){

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int target=-1*nums[i];
                int sum=nums[j]+nums[k];
                if(sum>target){
                    k--;
                }
                else if(sum<target){
                    j++;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    while (j < k && nums[j] == nums[j + 1])
                        j++;

                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                        
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}