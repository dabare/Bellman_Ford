/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class Graph {

    public Vertex[] vertices;
    public Edge[] edges;

    public Graph(int[] v, int[][] e) {
        this.vertices = new Vertex[v.length];
        this.edges = new Edge[e.length];

        for (int i = 0; i < v.length; i++) {
            this.vertices[i] = new Vertex(v[i]);
        }

        for (int i = 0; i < e.length; i++) {
            this.edges[i] = new Edge(find(e[i][0]), find(e[i][1]), e[i][2]);
        }

    }

    Vertex find(int s) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getID() == s) {
                return vertices[i];
            }
        }
        return null;
    }

    public Edge[] getAdjacent(Vertex u) {
        LinkList l = new LinkList();
        for (Edge e : edges) {
            if (e.source.equals(u)) {
                l.append(e.destination);
            }
        }

        Edge[] tmp = new Edge[l.getSize()];
        int index = 0;
        l = new LinkList();
        for (Edge e : edges) {
            if (e.source.equals(u)) {
                tmp[index] = e;
                index++;
            }
        }

        l = null;
        return tmp;
    }

    Vertex[] getPath(Vertex v) {
        LinkList l = new LinkList();
        while (v != null) {
            l.append(v);
            v = v.getParent();
        }
        Vertex tmp[] = new Vertex[l.getSize()];
        LinkListNode ln = l.getHead();
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = ln.v;
            ln = ln.next;
        }
        l = null;
        ln = null;
        return tmp;
    }
}
