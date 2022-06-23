package com.abdur.algorithms.traversal;



import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private final boolean[] visited;

    public DepthFirstSearch(int numVertices){
        visited = new boolean[numVertices];
    }

    public void traverseAdjList(List<List<Integer>> adjList , int startNode){
        Stack<Integer> s = new Stack<>();
        s.push(startNode);
        while (!s.isEmpty()){
            int nextNode = s.pop();
            if (!visited[nextNode]){
                visited[nextNode] = true;
                System.out.println(nextNode+" ");
                for (int nodes : adjList.get(nextNode)){
                    if (!visited[nodes])
                        s.push(nodes);
                }
            }
        }
    }

    public void traverseAdjMatrix(boolean[][] adjMatrix , int startNode){
        Stack<Integer> s = new Stack<>();
        s.push(startNode);
        while (!s.isEmpty()){
            int nextNode = s.pop();
            if (!visited[nextNode]){
                visited[nextNode] = true;
                System.out.println(nextNode+" ");
                for (int i = 0; i<adjMatrix.length;i++){
                    if (adjMatrix[nextNode][i] && !visited[i]){
                        s.push(i);
                    }
                }
            }
        }
    }


}
