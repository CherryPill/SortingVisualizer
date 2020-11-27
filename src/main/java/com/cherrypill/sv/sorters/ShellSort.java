package com.cherrypill.sv.sorters;

import com.cherrypill.sv.misc.Swapper;
import com.cherrypill.sv.shapes.Shape;
import com.cherrypill.sv.shapes.Square;

import java.util.ArrayList;
import java.lang.InterruptedException;
import javax.swing.JOptionPane;
import javax.swing.text.View;

public class ShellSort implements Runnable {
    ArrayList<Shape> shapes;
    int direction;
    View view;

    public ShellSort(ArrayList<Shape> shapes, int direction, View v) {
        this.direction = direction;
        this.shapes = shapes;
        this.view = v;
    }

    public void run() {
        this.sort();

    }

    public void sort() {
        int j;
        for (int gap = this.shapes.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < this.shapes.size(); i++) {
                Shape tempShape = new Square((Square) this.shapes.get(i));
                if (direction == 0) {
                    for (j = i; j >= gap && tempShape.compareTo(this.shapes.get(j - gap)) < 0; j -= gap) {
                        Shape first = this.shapes.get(j);
                        Shape second = this.shapes.get(j - gap);
                        new Swapper().swap(first, second);

                    }
                } else {
                    for (j = i; j >= gap && tempShape.compareTo(this.shapes.get(j - gap)) > 0; j -= gap) {
                        Shape first = this.shapes.get(j);
                        Shape second = this.shapes.get(j - gap);
                        new Swapper().swap(first, second);


                    }
                }
            }
        }
    }
}
