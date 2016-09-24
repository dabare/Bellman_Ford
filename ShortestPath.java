/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class ShortestPath {

    static LinkList S;
    static LinkList Q;
    static int infinity;

    static void Initialise_Single_source(Graph graph, Vertex source) {
        for (Vertex v : graph.vertices) {
            v.setDistance(infinity);
            v.setParent(null);
        }
        source.setDistance(0);
    }

    static void Relax(Vertex u, Vertex v, int w) {
        if (u.getDistance() + w < v.getDistance()) {
            v.setDistance(u.getDistance() + w);
            v.setParent(u);
        }
    }

    static Vertex Extract_Min(LinkList L) {
        LinkListNode l = L.getHead();
        LinkListNode min = l;
        while (l != null) {
            if (l.compareTo(min) < 0) {
                min = l;
            }
            l = l.next;
        }
        return L.pop(min).v;
    }

    static boolean ShortestPath_BellmanFord(Graph G, int start) {
        Vertex strt = G.find(start);
        Initialise_Single_source(G, strt);
        for (int i = 0; i < G.vertices.length - 1; i++) {
            for (Edge e : G.edges) {
                Relax(e.source, e.destination, e.weight);
            }
        }
        for (Edge e : G.edges) {
            if (e.destination.getDistance() > e.source.getDistance() + e.weight) {
                return false;
            }
        }

        return true;
    }

    static void Print_ShortestPath_Dijkstra(Graph G, int start) {
        System.out.println("Shortest paths from " + start + "to other vertices");
        if (ShortestPath_BellmanFord(G, start)) {
            for (Vertex v : G.vertices) {
                if (v.getDistance() == ShortestPath.infinity) {
                    System.out.println(start + "->" + v.getID() + "\t\t" + "(inf)*");
                } else {
                    Vertex tmp[] = G.getPath(v);
                    String s = "";
                    for (int i = 1; i < tmp.length; i++) {
                        s = tmp[i].getID() + "->" + s;
                    }
                    s = s + tmp[0].getID() + "\t\t(" + v.getDistance() + ")";
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("There is a negative-weight cycle that is reachable from the source " + start);
        }
    }
}
