class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        for (int i= k;  ;i+= k) {
            if (!set.contains(i)) return i;
        }
    }
}