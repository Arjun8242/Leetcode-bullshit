/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean check=false;

        if(root==null) return ans;

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                list.add(node.val);

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

            if(check) Collections.reverse(list);
            check=!check;

            ans.add(list);


        }
        return ans;
    }
}