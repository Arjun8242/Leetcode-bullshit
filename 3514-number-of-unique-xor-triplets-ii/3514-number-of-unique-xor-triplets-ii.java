class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] one = new boolean[2048];
        boolean[] two = new boolean[2048];
        boolean[] three = new boolean[2048];

        // XOR of one element
        for (int num : nums) {
            one[num] = true;
        }

        // XOR of two elements
        for (int x = 0; x < 2048; x++) {
            if (!one[x]) continue;

            for (int num : nums) {
                two[x ^ num] = true;
            }
        }

        // XOR of three elements
        for (int x = 0; x < 2048; x++) {
            if (!two[x]) continue;

            for (int num : nums) {
                three[x ^ num] = true;
            }
        }

        int ans = 0;
        for (boolean b : three) {
            if (b) ans++;
        }

        return ans;
    }
}