package Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {

    Vertex[] vertexArr;
    int[][] adjArr;
    int n;
    int currentVertex = 0;
    int[] vertexDistance;

    public Graph (int n) {
        this.n = n;
        this.vertexArr = new Vertex[n];
        this.adjArr = new int[n][n];
        this.vertexDistance = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjArr[i][j] = 0;
            }
            vertexDistance[i] = 0;
        }
    }

    public void addVertx (int value) {
        vertexArr[currentVertex++] = new Vertex(value);
    }

    public void addEdge (int start, int end) {
        adjArr[start][end] = 1;
        adjArr[end][start] = 1;
    }

    private int getVertexId (Vertex vertex) {
        Vertex compare = vertexArr[0];
        int i = 1;
        while (vertex != compare) {
            compare = vertexArr[i++];
        }
        i--;
        return i;
    }

    public void bfs (int start) {
        Queue<Vertex> queue = new ArrayDeque<>(); // zainicjalizowanie nowej kolejki
        queue.add(vertexArr[start]); // pierwszy element kolejki to wierzcholek na ktory wskazujemy w argumencie funkcji
        while (queue.size() != 0) { // petle wykonujemy dopoki kolejka nie bedzie pusta
            Vertex vertex = queue.remove(); // sciagamy pierwszy element z kolejki
            vertex.wasVisited = true; // oznaczamy, ze byl juz odwiedzony
            int vertexId = getVertexId(vertex); // bierzemy jego wartosc, aby miec dostep do jego sasiadow (z tablicy adjArr)
            int i = 0; // inicjalizujemy iterator
            System.out.print(vertex.value + ": "); // wypisujemy
            while (i != currentVertex) { // iterujemy tyle razy ile jest wierzcholkow
                if (adjArr[vertexId][i] == 1 && !vertexArr[i].wasVisited) { // jezeli natrafilismy na wierzcholek, ktory jest polaczony z wierzcholkiem, ktory aktualnie sprawdzamy i jest nie odwiedzony to wykonujemy
                    vertexArr[i].wasVisited = true; // ustalamy flage visited na true
                    queue.add(vertexArr[i]); // dodajemy wierzcholek do kolejki
                    System.out.print(vertexArr[i].value + " "); // wypisujemy wartosc
                }
                i++; // dodajemy do iteratora
            }
            System.out.println(); // robimy enter zeby wynik byl czytelny
        }
    }


    static class Vertex {
        int value;
        boolean wasVisited;

        public Vertex (int value) {
            this.value = value;
        }
    }
}
