package com.example.test3d;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Test3DController implements Initializable {
    @FXML
    private Canvas mainCanvas;

    Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Camera camera = new Camera(0, 0, -2, new Normal(0, 0, 1));
        ArrayList<Polyhedron> polyhedrons = new ArrayList<Polyhedron>();
        File directory = new File("objects");
        for (String filename : directory.list()){
            polyhedrons.add(new Polyhedron("objects/" + filename));
        }
        ArrayList<Light>lights = new ArrayList<>();
        lights.add(new Light(0, 10, 0, 1));
        scene = new Scene(lights, camera, polyhedrons);
    }
}
