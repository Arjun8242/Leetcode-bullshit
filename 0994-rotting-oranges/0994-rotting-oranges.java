class Solution {
    public int orangesRotting(int[][] grid) {
        int total=0;
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        int time=0;
        int[][] dirs={{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[] {i, j});
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int x=curr[0];
                int y=curr[1];

                for(int[] d:dirs){
                    int dx=x+d[0];
                    int dy=y+d[1];

                    if(dx<n && dx>=0 && dy<m && dy>=0 && grid[dx][dy]==1){
                        grid[dx][dy]=2;
                        queue.offer(new int[]{dx, dy});
                        total++;
                    }
                }
            }
            time++;
        }
        return total==fresh?time-1:-1;
    }
}