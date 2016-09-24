/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class LinkList {

    private LinkListNode head;
    private int size;

    public LinkList() {
        head = null;
        size = 0;
    }

    public void append(Vertex v) {
        if (head == null) {
            head = new LinkListNode(v);
            size++;
            return;
        }
        LinkListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new LinkListNode(v);
        size++;
    }

    public int getSize() {
        return size;
    }

    public LinkListNode getHead() {
        return head;
    }

    public LinkListNode pop(LinkListNode n) {
        LinkListNode parent = head;
        if (head.equals(n)) {
            head = head.next;
            n.next = null;
            size--;
        } else {
            while (!parent.next.equals(n)) {
                parent = parent.next;
            }
            parent.next = parent.next.next;
            n.next = null;
            size--;
        }

        return n;
    }

    public Vertex pop(Vertex v) {
        return pop(find(v)).v;
    }

    public LinkListNode find(Vertex v) {
        LinkListNode tmp = head;
        while (tmp != null && !tmp.v.equals(v)) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
