package com.CS5343;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BellmanFord {
    public static int INF = Integer.MAX_VALUE;
    Map<Integer, Character> vertices;


    public BellmanFord()
    {
        Vertices();
    }

    private void Vertices()
    {
        vertices = new HashMap<>();
        vertices.put(0, 'S');
        vertices.put(1, 'T');
        vertices.put(2, 'X');
        vertices.put(3, 'Y');
        vertices.put(4, 'Z');
        vertices.put(5, 'A');
        vertices.put(6, 'B');
        vertices.put(7, 'C');
        vertices.put(8, 'D');
        vertices.put(9, 'E');

    }

    public void bellmanFord(Vector<Edge> edges, int nnodes, int source)
    {
        int[] distance = new int[nnodes];
        Arrays.fill(distance, INF);
        int[] parent = new int[nnodes];
        Arrays.fill(parent, -1);
        distance[source] = 0;
        int newDistance;

        for (int i = 1; i < nnodes; ++i)
        {
            for (int j = 0; j < edges.size(); ++j)
            {
                if (distance[edges.get(j).source] == INF)
                    continue;
                else
                {
                    newDistance = distance[edges.get(j).source] + edges.get(j).weight;
                    if (newDistance < distance[edges.get(j).destination])
                    {
                        distance[edges.get(j).destination] = newDistance;
                        parent[edges.get(j).destination] = edges.get(j).source;
                    }
                }
            }
        }

        for (int i = 0; i < edges.size(); ++i)
        {
            newDistance = distance[edges.get(i).source] + edges.get(i).weight;
            if (distance[edges.get(i).source] != INF && newDistance < distance[edges.get(i).destination])
            {
                System.out.println("Negative Cycle detected in the graph");
                for (i = 0; i < distance.length; ++i)
                {
                    System.out.println("Vertex:" + vertices.get(i) + " Distance:" + distance[i] + " Parent:" + vertices.get(parent[i]));
                }
                System.out.println();
                return;
            }
        }

        for (int i = 0; i < distance.length; ++i)
        {
            if (distance[i] == INF)
            {
                System.out.println("There's no path between " + vertices.get(source) + " and " + vertices.get(i));
            }
            else
            {
                System.out.println("Vertex:" + vertices.get(i) + " Distance:" + distance[i] + " Parent:" + vertices.get(parent[i]));
            }
        }
    }

    public void printEdges(Vector<Edge> edges)
    {
        for(int i=0; i<edges.size(); i++)
        {
            System.out.println("("+ vertices.get(edges.get(i).source)+ "," +vertices.get(edges.get(i).destination)+ ") = "+edges.get(i).weight);
        }
    }

        static class Edge
        {
            int source;
            int destination;
            int weight;

            public Edge(int s, int d, int w)
            {
                source = s;
                destination = d;
                weight = w;
            }
        }
}
