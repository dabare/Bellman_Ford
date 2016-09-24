/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class main {

    public static void main(String[] args) {
        ShortestPath.infinity = 100000; // here the 100 000 is used as infinity

        int vertices[] = {1, 2, 3, 4, 5, 6};
        int edges[][] = {//source , destination , weight
            {1, 2, 9},
            {1, 3, 7},
            {1, 5, 6},
            {1, 6, 8},
            {2, 3, -3},
            {3, 5, -3},
            {4, 3, -1},
            {6, 4, -2}};

        int start = 1;

        Graph graph = new Graph(vertices, edges);
        ShortestPath.Print_ShortestPath_Dijkstra(graph, start);

    }
}
