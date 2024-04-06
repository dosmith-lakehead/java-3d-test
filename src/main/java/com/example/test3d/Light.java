package com.example.test3d;

public class Light extends Vertex {
    int brightness;

    public Light(double x, double y, double z, int brightness){
        super(x, y, z);
        this.brightness = brightness;
    }
}
