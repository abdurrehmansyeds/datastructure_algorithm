package com.abdur.datastructres.graph;


import com.abdur.algorithms.traversal.BreadthFirstSearch;
import com.abdur.algorithms.traversal.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class ListGraph {

    private final int numVertices;
    private final List<List<Integer>> adjList;

    public ListGraph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i=0;i<numVertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i=0;i<numVertices;i++){
            s.append(i+ ": ");
            for (int d : adjList.get(i)){
                s.append(d +" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ListGraph graph =  new ListGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        DepthFirstSearch t = new DepthFirstSearch(4);
        t.traverseAdjList(graph.adjList, 0);
        BreadthFirstSearch b = new BreadthFirstSearch(4);
        b.traverseAdjList(graph.adjList, 0);
    }

}
