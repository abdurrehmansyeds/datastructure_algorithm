package com.abdur.algorithms.traversal;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    private final boolean[] visited;

    public BreadthFirstSearch(int num) {
        visited = new boolean[num];
    }

    public void traverseAdjList(List<List<Integer>> adjList, int startNode){
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        while (!q.isEmpty()){
            int nextNode = q.poll();
            if (!visited[nextNode]){
                visited[nextNode] = true;
                System.out.println(nextNode+" ");
                for (int node : adjList.get(nextNode)){
                    if (!visited[node]){
                        q.offer(node);
                    }
                }
            }
        }
    }

    public void traverseAdjMatrix(boolean[][] adjMatrix, int startNode){
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        while (!q.isEmpty()){
            int nextNode = q.poll();
            if (!visited[nextNode]){
                visited[nextNode] = true;
                System.out.println(nextNode+" ");
                for (int i=0;i<adjMatrix.length;i++){
                    if (adjMatrix[nextNode][i] && !visited[i]){
                        q.offer(i);
                    }
                }
            }
        }
    }
}
