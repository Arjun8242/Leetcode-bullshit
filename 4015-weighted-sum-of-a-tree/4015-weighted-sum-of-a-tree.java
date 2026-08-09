class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n=parent.length;
        List<List<Integer>> graph=new ArrayList<>();
        int[] depth=new int[n];
        int height=1;
        depth[0]=1;
        long ans=0;
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            graph.get(parent[i]).add(i);
        }
        

        q.offer(0);

        while(!q.isEmpty()){
            int node=q.poll();

            for(int neigh:graph.get(node)){
                depth[neigh]=depth[node]+1;
                height=Math.max(height, depth[neigh]);
                q.offer(neigh);
            }
        }

        for(int i=0;i<n;i++){
            ans+=(long) nums[i]*(height-depth[i]+1);
        }

        return ans;



    }
}