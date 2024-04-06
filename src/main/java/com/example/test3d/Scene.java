package com.example.test3d;

import javafx.scene.effect.Light;

import java.util.ArrayList;

public class Scene {
    public ArrayList<Polyhedron> polyhedrons;
    public ArrayList<Light> lights;

    public Scene(ArrayList<Polyhedron> polyhedrons, ArrayList<Light> lights) {
        this.polyhedrons = polyhedrons;
        this.lights = lights;
    }
}
