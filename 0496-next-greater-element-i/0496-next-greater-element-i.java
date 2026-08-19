class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        int n=nums2.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                stack.pop();
            }
            int nge=stack.isEmpty()?-1:stack.peek();
            map.put(nums2[i], nge);
            stack.push(nums2[i]);
        }

        for(int i=0;i<ans.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}