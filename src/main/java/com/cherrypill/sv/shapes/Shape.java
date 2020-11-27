package com.cherrypill.sv.shapes;

import java.awt.Color;

public abstract class Shape implements Comparable<Shape> {
    public int size = 0;
    public int xCoord = 0;
    public int yCoord = 0;
    public Color shapeColor = null;
    public int shapeIndex;
    public static int totalShapesCount;

    public abstract int compareTo(Shape shape);
}