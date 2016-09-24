/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class LinkListNode implements Comparable<LinkListNode> {

    public Vertex v;
    public LinkListNode next;

    public LinkListNode(Vertex v, LinkListNode next) {
        this.v = v;
        this.next = next;
    }

    public LinkListNode(Vertex v) {
        this(v, null);
    }

    public LinkListNode() {
        this(null, null);
    }

    @Override
    public int compareTo(LinkListNode o) {
        int u = v.getDistance();
        int v = o.v.getDistance();
        if (u == v) {
            return 0;
        }
        if (u > v) {
            return 1;
        }
        return -1;
    }

}
