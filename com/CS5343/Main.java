package com.CS5343;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<BellmanFord.Edge> edges = new Vector<BellmanFord.Edge>();
        edges.add(new BellmanFord.Edge(0, 1, 6));
        edges.add(new BellmanFord.Edge(0, 3, 7));
        edges.add(new BellmanFord.Edge(1, 2, 5));
        edges.add(new BellmanFord.Edge(1, 3, 8));
        edges.add(new BellmanFord.Edge(1, 4, -4));
        edges.add(new BellmanFord.Edge(2, 1, -2));
        edges.add(new BellmanFord.Edge(3, 4, 9));
        edges.add(new BellmanFord.Edge(4, 2, 7));
        edges.add(new BellmanFord.Edge(4, 0, 2));
        edges.add(new BellmanFord.Edge(2, 5, 6));
        edges.add(new BellmanFord.Edge(5, 2, 5));
        edges.add(new BellmanFord.Edge(5, 6, 4));
        edges.add(new BellmanFord.Edge(5, 7, -4));
        edges.add(new BellmanFord.Edge(6, 2, -2));
        edges.add(new BellmanFord.Edge(6, 4, 4));
        edges.add(new BellmanFord.Edge(5, 8, 2));
        edges.add(new BellmanFord.Edge(6, 9, 7));
        edges.add(new BellmanFord.Edge(7, 9, -1));
        edges.add(new BellmanFord.Edge(8, 9, 3));

        Vector<BellmanFord.Edge> edgesSet1 = new Vector<BellmanFord.Edge>();
        Vector<BellmanFord.Edge> edgesSet2 = new Vector<BellmanFord.Edge>();

        edgesSet1.addAll(edges);
        edgesSet2.addAll(edges);

        edgesSet1.add(new BellmanFord.Edge(3, 2, -3));
        edgesSet2.add(new BellmanFord.Edge(3, 2, -7));

        BellmanFord b = new BellmanFord();
        b.printEdges(edges);

        System.out.println();
        System.out.println("Output when edge Y->X has weight -3: ");
        b.bellmanFord(edgesSet1, 10, 0);

        System.out.println();
        System.out.println("Output when edge Y->X has weight -7: ");
        b.bellmanFord(edgesSet2, 10, 0);
    }
}
