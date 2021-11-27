package DisjointSet;

class Solution116_省份数量 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,1,1},
                {1,1,0,1},
                {1,0,1,1}
        };
        System.out.println(findCircleNum(grid));
    }
    public static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public static  void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
            return parent[index];//路径压缩
        }
        return parent[index];
    }
}
