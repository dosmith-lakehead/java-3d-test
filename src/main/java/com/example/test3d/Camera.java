package com.example.test3d;

public class Camera extends Vertex{
    double width = 1.6;
    double height = 0.9;
    double depth = 0.5;
    double range = 20.0;
    double x, y, z;
    Normal normal;

    Normal upNormal = new Normal (0, 1, 0);

    public Camera(double x, double y, double z, Normal normal){
        super(x,y,z);
        this.normal = normal;
    }

    public TwoDPoint[] get2DShapeFromFace(Face face){
        for (Vertex vertex : face.vertices){
            double t = (this.normal.x * vertex.x + this.normal.y * vertex.y + this.normal.z * vertex.z - (this.normal.x * this.x + this.normal.y * this.y + this.normal.z * this.z)) / (this.normal.x * this.normal.x + this.normal.y * this.normal.y + this.normal.z * this.normal.z);

            Vertex pointOnCameraNormal = new Vertex(this.normal.x * t, this.normal.y * t, this.normal.z * t);

            double distUp = (this.upNormal.x * vertex.x + this.upNormal.y * vertex.y + this.upNormal.z * vertex.z - (this.upNormal.x * pointOnCameraNormal.x + this.upNormal.y * pointOnCameraNormal.y + this.upNormal.z * pointOnCameraNormal.z)) / (this.upNormal.x * this.upNormal.x + this.upNormal.y * this.upNormal.y + this.upNormal.z * this.upNormal.z);

            // Figure out camera right vector
            // Get rightward distance
            // Return x,y coords
        }
    }
}
