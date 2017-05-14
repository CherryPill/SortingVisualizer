/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Color;

/**
 *
 * @author Theta1
 */
public abstract class Shape implements Comparable<Shape> {
    public int size = 0;
    public int xCoord = 0;
    public int yCoord = 0;
    public Color shapeColor = null;
    public int shapeIndex;
    public static int totalShapesCount;
    public abstract int compareTo(Shape shape);
}