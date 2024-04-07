package com.example.test3d;

import java.util.ArrayList;

public class Camera extends Vertex {
    double width = 1.6;
    double height = 0.9;
    double depth = 0.5;
    double range = 20.0;
    double x, y, z;
    Normal normal;

    Normal upNormal = new Normal (0, 1, 0);
    Normal rightNormal;

    public Camera(double x, double y, double z, Normal normal){
        super(x,y,z);
        this.normal = normal;
        double[] crossProduct = {this.normal.y * this.upNormal.z - this.normal.z * this.upNormal.y, this.normal.z * this.upNormal.x - this.normal.x * this.upNormal.z, this.normal.x * this.upNormal.y - this.normal.y * this.upNormal.x};
        double magnitude = Math.sqrt(crossProduct[0] * crossProduct[0] + crossProduct[1] * crossProduct[1] + crossProduct[2] * crossProduct[2]);
        this.rightNormal = new Normal(crossProduct[0] / magnitude, crossProduct[1] / magnitude, crossProduct[2] / magnitude);
    }

    public ArrayList<TwoDPoint> get2DShapeFromFace(Face face){
        ArrayList<TwoDPoint> twoDPoints = new ArrayList<TwoDPoint>();
        for (Vertex vertex : face.vertices){
            double t = (this.normal.x * vertex.x + this.normal.y * vertex.y + this.normal.z * vertex.z - (this.normal.x * this.x + this.normal.y * this.y + this.normal.z * this.z)) / (this.normal.x * this.normal.x + this.normal.y * this.normal.y + this.normal.z * this.normal.z);

            Vertex pointOnCameraNormal = new Vertex(this.normal.x * t, this.normal.y * t, this.normal.z * t);

            double distUp = (this.upNormal.x * vertex.x + this.upNormal.y * vertex.y + this.upNormal.z * vertex.z - (this.upNormal.x * pointOnCameraNormal.x + this.upNormal.y * pointOnCameraNormal.y + this.upNormal.z * pointOnCameraNormal.z)) / (this.upNormal.x * this.upNormal.x + this.upNormal.y * this.upNormal.y + this.upNormal.z * this.upNormal.z);

            double upScale = Math.abs((t + depth)) * (height / 2) / depth;

            distUp /= upScale;

            double distRight = (this.rightNormal.x * vertex.x + this.rightNormal.y * vertex.y + this.rightNormal.z * vertex.z - (this.rightNormal.x * pointOnCameraNormal.x + this.rightNormal.y * pointOnCameraNormal.y + this.rightNormal.z * pointOnCameraNormal.z)) / (this.rightNormal.x * this.rightNormal.x + this.rightNormal.y * this.rightNormal.y + this.rightNormal.z * this.rightNormal.z);

            double rightScale = Math.abs((t + depth)) * (width / 2) / depth;

            distRight /= rightScale;

            if (t<0){
                distUp = (distUp > 0 ? height * 3/2  - distUp : -height/2)
                distRight =
            }

            twoDPoints.add(new TwoDPoint((int)Math.round(distRight), (int)Math.round(distUp)));
        }
        return twoDPoints;
    }
}

