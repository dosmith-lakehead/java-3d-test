package com.example.test3d;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Polyhedron {
    public ArrayList<Vertex> vertices;
    public ArrayList<Normal> normals;
    public ArrayList<Face> faces;

    public Polyhedron(String objFileLoc){
        vertices = new ArrayList<Vertex>();
        normals = new ArrayList<Normal>();
        faces = new ArrayList<Face>();
        try {
            Scanner scanner = new Scanner(new File(objFileLoc));
            while (scanner.hasNext()){
                String[] input = scanner.nextLine().split(" ");
                if (input[0].equals("v")){
                    Vertex vertex = new Vertex(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));
                    vertices.add(vertex);
                }
                else if (input[0].equals("vn")){
                    Normal normal = new Normal(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]));
                    normals.add(normal);
                }
                else if (input[0].equals("f")) {
                    ArrayList<Vertex> faceVertices = new ArrayList<Vertex>();
                    for (int i = 1; i < input.length - 1; i++) {
                        faceVertices.add(vertices.get(Integer.parseInt(input[i].split("//")[0]) - 1));
                    }
                    Face face = new Face(faceVertices, normals.get(Integer.parseInt(input[1].split("//")[1]) - 1));
                    faces.add(face);
                }
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
