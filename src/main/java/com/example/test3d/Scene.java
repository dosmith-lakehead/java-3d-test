package com.example.test3d;

import java.util.ArrayList;

public class Scene {
    public ArrayList<Polyhedron> polyhedrons;
    public ArrayList<Light> lights;

    public Scene(ArrayList<Light> lights, Camera camera, ArrayList<Polyhedron> polyhedrons) {
        this.polyhedrons = polyhedrons;
        this.lights = lights;
    }
}
