package com.abdur.datastructres.graph;

import com.abdur.algorithms.traversal.BreadthFirstSearch;
import com.abdur.algorithms.traversal.DepthFirstSearch;

public class MatrixGraph {

    private final boolean[][] adjMatrix;
    private final int numVertices;

    public  MatrixGraph(int numVertices){
        this.numVertices= numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int u, int v){
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;
    }

    public void removeEdge(int u, int v){
        adjMatrix[u][v] = false;
        adjMatrix[v][u] = false;
    }

    @Override
    public String toString(){
        StringBuilder s  = new StringBuilder();
        for (int i = 0; i<numVertices; i++){
            s.append(i+ ": ");
            for (boolean j : adjMatrix[i]){
                s.append((j?1:0)+" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        MatrixGraph g = new MatrixGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        DepthFirstSearch t = new DepthFirstSearch(4);
        t.traverseAdjMatrix(g.adjMatrix,3);
        BreadthFirstSearch b = new BreadthFirstSearch(4);
        b.traverseAdjMatrix(g.adjMatrix,0);
    }
}
