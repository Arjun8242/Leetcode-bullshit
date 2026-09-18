class Solution {
    List<Integer>[] graph;
    int[] subtree;
    int[] answer;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph=new ArrayList[n];
        subtree=new int[n];
        answer=new int[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

    //     int[][] dist=new int[n][n];

    //     for(int i=0;i<n;i++){
    //         dfs(i, -1, 0, i, graph, dist);
    //     }

    //     int[] ans=new int[n];

    //     for(int i=0;i<n;i++){
    //         int sum=0;
    //         for(int j=0;j<n;j++){
    //             sum+=dist[i][j];
    //         }

    //         ans[i]+=sum;
    //     }

    //     return ans;
    // }

    // public void dfs(int node, int parent, int distance, int source, List<Integer>[] graph, int[][] dist){
    //     dist[source][node]=distance;

    //     for(int neig:graph[node]){
    //         if(neig==parent) continue;

    //         dfs(neig, node, distance+1, source, graph, dist);
    //     }
    // }

        dfs1(0, -1);

        dfs2(0, -1, n);

        return answer;

    }


    public void dfs1(int node, int parent){
        //count yourselff
        subtree[node]=1;

        for(int child:graph[node]){

            if(child==parent) continue;

            // First calculate child's subtree
            dfs1(child, node);
            
            // Add child's subtree to current node
            subtree[node]+=subtree[child];

            // Every node inside child's subtree is 1 edge farther from node 0
            answer[0]+=subtree[child];
        }
    }

    public void dfs2(int node, int parent, int n){
        for(int child:graph[node]){

            if(child==parent) continue;

            
            answer[child]=answer[node]+n-2*subtree[child];

            dfs2(child, node, n);
        }
    }
}