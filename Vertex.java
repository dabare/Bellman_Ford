/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class Vertex {

    private int ID;
    private int distance;
    private Vertex parent;

    public Vertex(int ID, int distance, Vertex parent) {
        this.ID = ID;
        this.distance = distance;
        this.parent = parent;
    }

    public Vertex(int ID) {
        this(ID, -1, null);
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Vertex getParent() {
        return parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getID() {
        return ID;
    }

   
}
