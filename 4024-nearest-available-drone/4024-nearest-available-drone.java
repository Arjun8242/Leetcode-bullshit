class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n=drones.length;
        int mindistance=Integer.MAX_VALUE;
        int minind=-1;


        for(int i=0;i<n;i++){
            int[] x=drones[i];
            int distance=Math.abs(x[0]-target[0])+Math.abs(x[1]-target[1]); 
            if(distance>x[2]){
                continue;
            }

            if(distance<mindistance){
                mindistance=distance;
                minind=i;
            }
        }

        return minind;
    }
}