package com.cherrypill.sv.misc;

import com.cherrypill.sv.shapes.Shape;

import java.awt.Color;


//swaps color and size, repaints
public class Swapper implements Swappable {
    @Override
    public void swap(Shape first, Shape second) {
        if (first.xCoord != second.xCoord) {
            Color temp;
            temp = first.shapeColor;
            first.shapeColor = second.shapeColor;
            second.shapeColor = temp;

            first.size ^= second.size;
            second.size ^= first.size;
            first.size ^= second.size;
        }


    }

    public void Clone(Shape first, Shape second) {
        if (first.xCoord != second.xCoord) {
            first.shapeColor = second.shapeColor;
            first.size = second.size;
        }
    }
}
