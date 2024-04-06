package com.example.test3d;

import java.util.ArrayList;

public class Vertex {
    public double x, y, z;
    public ArrayList<Face> connectedFaces;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
