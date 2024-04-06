package com.example.test3d;

import java.util.ArrayList;

public class Face {
    public ArrayList<Vertex> vertices;
    Normal normal;
    public int numVertices;

    public Face(ArrayList<Vertex> vertices, Normal normal) {
        this.vertices = vertices;
        numVertices = vertices.size();
        this.normal = normal;
        for (Vertex vertex : vertices){
            vertex.connectedFaces.add(this);
        }
    }
}
