package DFS2BFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//����
    private int[][] edges; //��
    private  boolean[] visited;//�Ƿ񱻷���
    private  int numOfEdges;
    public static void main(String[] args) {
         int n = 8;
//         String[] arr = {"A", "B", "C", "D", "E"};
         String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8"};
         Graph graph = new Graph(n);
         for(String vertex : arr){
             graph.addVertex(vertex);
         }

        //A-B A-C B-C B-D B-E  ��ӱ�
//		graph.addAdge(0, 1, 1); // A-B
//		graph.addAdge(0, 2, 1); //
//		graph.addAdge(1, 2, 1); //
//		graph.addAdge(1, 3, 1); //
//		graph.addAdge(1, 4, 1); //
        //���±ߵĹ�ϵ
        graph.addAdge(0, 1, 1);
        graph.addAdge(0, 2, 1);
        graph.addAdge(1, 3, 1);
        graph.addAdge(1, 4, 1);
        graph.addAdge(3, 7, 1);
        graph.addAdge(4, 7, 1);
        graph.addAdge(2, 5, 1);
        graph.addAdge(2, 6, 1);
        graph.addAdge(5, 6, 1);
//        graph.showGraph();
        System.out.println("��ȱ���");
        graph.dfs(); // A->B->C->D->E 

    }

    private void dfs() {
        visited = new boolean[vertexList.size()];
        for(int i = 0; i < vertexList.size(); i++){
            if(!visited[i]){
              dfs(visited,i);
            }
        }
    }

    private void dfs(boolean[] visited, int i) {
        //�ȴ�ӡ��ǰԪ��
        System.out.print(vertexList.get(i)+ " -> ");
        visited[i] = true;
        int next  = getFisrtNeighbor(i);
        while(next != -1){
            if(!visited[next]){
                dfs(visited, next);
            }
            next = getNextNeighbor(i, next);
        }
    }

    private int getNextNeighbor(int index, int next) {
        for(int i = next + 1; i < vertexList.size(); i++){
            if(edges[index][i] > 0){
               return i;
            }
        }
        return -1;
    }

    /*
      ���ҵ�һ����߽ڵ�
     */
    private int getFisrtNeighbor(int index) {
        for(int i = 0; i < vertexList.size(); i++){
            if(edges[index][i] > 0){
                return i;
            }
        }
        return  -1;
    }

    private void showGraph() {
        for(int[] edge : edges){
            System.out.println(Arrays.toString(edge));
        }
    }

    private void addAdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight; //����ͼ
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    private void addVertex(String vertex) {
        vertexList.add(vertex);
    }

    public Graph(int n){
       edges = new int[n][n];
       vertexList = new ArrayList<String>(n);
//       visited = new boolean[n];
    }
}
